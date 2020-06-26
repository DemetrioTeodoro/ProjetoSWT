package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Cliente;
import model.entity.Endereco;
import model.seletor.ClienteSeletor;

public class ClienteDAO implements BaseDAO<Cliente> {

	public Cliente salvar(Cliente cliente) {

		Endereco endereco = null;
		if (cliente.getEndereco() != null) {
			EnderecoDAO enderecoDAO = new EnderecoDAO();

			endereco = enderecoDAO.salvar(cliente.getEndereco());

		}

		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE ( nome, inscricao, ecpf, ativo, data_cadastro, telefone, email, id_endereco) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getInscricao());
			stmt.setBoolean(3, cliente.isEhCpf());
			stmt.setBoolean(4, cliente.isAtivo());
			stmt.setDate(5, Date.valueOf(cliente.getDataCadastro()));
			stmt.setString(6, cliente.getTelefone());
			stmt.setString(7, cliente.getEmail());
			stmt.setInt(8, endereco.getId());
			stmt.execute();

			ResultSet resultado = stmt.getGeneratedKeys();

			if (resultado.next()) {
				cliente.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(" Erro ao salvar cliente. Causa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return cliente;
	}

	public boolean atualizar(Cliente cliente) {
		Connection conexao = Banco.getConnection();

		EnderecoDAO enderecoDAO = new EnderecoDAO();

		boolean enderecoAtualizado = enderecoDAO.atualizar(cliente.getEndereco());

		String sql = " UPDATE CLIENTE SET nome=?, inscricao=?, ecpf=?, ativo=?, data_cadastro=?, telefone=?, email=? WHERE id = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados = 0;

		try {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getInscricao());
			stmt.setBoolean(3, cliente.isEhCpf());
			stmt.setBoolean(4, cliente.isAtivo());
			stmt.setDate(5, Date.valueOf(cliente.getDataCadastro()));
			stmt.setInt(6, Integer.parseInt(cliente.getTelefone()));
			stmt.setString(7, cliente.getEmail());
			stmt.setInt(8, cliente.getId());

			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return registrosAlterados > 0;
	}

	public boolean excluir(int id) {
		String sql = " DELETE FROM CLIENTE WHERE id = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			preparedStatement.setInt(1, id);
			int codigoRetornoUpdate = preparedStatement.executeUpdate();

			excluiu = (codigoRetornoUpdate == Banco.CODIGO_RETORNO_SUCESSO_EXCLUSAO);
		} catch (SQLException ex) {
			System.out.println(" Erro ao excluir cliente. Id: " + id + " .Causa: " + ex.getMessage());
		} finally {
			Banco.closeStatement(preparedStatement);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public Cliente consultarPorId(int id) {
		String sql = " SELECT * FROM CLIENTE WHERE id = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		Cliente clienteConsultado = null;
		try {
			preparedStatement.setInt(1, id);
			ResultSet conjuntoResultante = preparedStatement.executeQuery();

			if (conjuntoResultante.next()) {
				clienteConsultado = construirClienteDoResultSet(conjuntoResultante);
			}
		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar cliente. Id: " + id + " .Causa: " + ex.getMessage());
		} finally {
			Banco.closeStatement(preparedStatement);
			Banco.closeConnection(conexao);
		}
		return clienteConsultado;
	}

	public ArrayList<Cliente> listarTodos() {
		String sql = " SELECT * FROM CLIENTE ";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet conjuntoResultante = preparedStatement.executeQuery();
			while (conjuntoResultante.next()) {
				Cliente cliente = construirClienteDoResultSet(conjuntoResultante);
				clientes.add(cliente);
			}

		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar todos os cliente. Causa: " + ex.getMessage());
		} finally {
			Banco.closeStatement(preparedStatement);
			Banco.closeConnection(conexao);
		}
		return clientes;
	}

	private Cliente construirClienteDoResultSet(ResultSet conjuntoResultante) {
		Cliente cliente = new Cliente();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			cliente.setId(conjuntoResultante.getInt("id"));
			cliente.setNome(conjuntoResultante.getString("nome"));
			cliente.setInscricao(conjuntoResultante.getString("inscricao"));
			cliente.setEhCpf(conjuntoResultante.getBoolean("ecpf"));
			cliente.setAtivo(conjuntoResultante.getBoolean("ativo"));
			cliente.setDataCadastro(conjuntoResultante.getDate("data_cadastro").toLocalDate());
			cliente.setTelefone(conjuntoResultante.getString("telefone"));
			cliente.setEmail(conjuntoResultante.getString("email"));
			cliente.setEndereco(enderecoDAO.consultarPorId(conjuntoResultante.getInt("id_endereco")));
		} catch (SQLException ex) {
			System.out.println(" Erro ao construir cliente a partir do ResultSet. Causa: " + ex.getMessage());
		}
		return cliente;
	}

	public boolean inscricaoJaUtilizada(String inscricao) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE C " + " WHERE C.inscricao = '" + inscricao + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		boolean jaUsada = false;

		try {
			ResultSet rs = stmt.executeQuery();
			jaUsada = rs.next();

		} catch (Exception e) {
			System.out.println("Erro ao verificar se a incrição (cpf ou cnpj)" + inscricao
					+ " já está sendo utilizada por cliente. Causa:" + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return jaUsada;
	}

	public Endereco consultarEndereco(Cliente clienteSelecionado) {
		Endereco end = new Endereco();
		EnderecoDAO endDAO = new EnderecoDAO();
		end = endDAO.consultarPorId(clienteSelecionado.getEndereco().getId());
		return end;
	}

	public ArrayList<Cliente> listarPorSeletor(ClienteSeletor seletor) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE C ";

		if (seletor.temFiltro()) {
			sql = criarFiltros(sql, seletor);
		}

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = construirClienteDoResultSet(rs);
				clientes.add(c);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes por seletor.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return clientes;
	}
	
	private String criarFiltros(String sql, ClienteSeletor seletor) {

		boolean primeiro = true;
		sql += " WHERE ";

		if (seletor.getNome() != null && seletor.getNome().trim().length() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " C.nome LIKE " + "'%" + seletor.getNome() + "%' ";
			primeiro = false;
		}

		if (seletor.getInscricao() != null && seletor.getInscricao().trim().length() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " C.inscricao LIKE " + "'%" + seletor.getInscricao() + "%' ";
		}

		return sql;
	}

}
