package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.details.Agenda;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;
import model.seletor.AgendaSeletor;
import model.seletor.OrdemServicoSeletor;

public class OrdemServicoDAO implements BaseDAO<OrdemServico> {

	public OrdemServico salvar(OrdemServico ordemServico) {
		Connection conexao = Banco.getConnection();

		/**
		 * Pega data atual para coluna: data_cadastro
		 */
		java.util.Date dataNova = new java.util.Date();
		String dataCadastro = new SimpleDateFormat("yyy-MM-dd").format(dataNova);
		System.out.println(dataCadastro);

		Endereco endereco = null;
		if (ordemServico.getEndereco() != null) {
			EnderecoDAO enderecoDAO = new EnderecoDAO();

			endereco = enderecoDAO.salvar(ordemServico.getEndereco());

		}

		String sql = " INSERT INTO ORDEM_SERVICO ( numero_os, descricao, data_cadastro, data_inicio, data_termino_previsto, data_termino, id_cliente, id_endereco) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, ordemServico.getNumeroOS());
			stmt.setString(2, ordemServico.getDescricao());
			stmt.setString(3, dataCadastro);
			stmt.setDate(4, Date.valueOf(ordemServico.getDataInicio()));
			stmt.setDate(5, Date.valueOf(ordemServico.getDataPrevistaFim()));
			if (ordemServico.getDataTermino() != null) {
				stmt.setDate(6, Date.valueOf(ordemServico.getDataTermino()));
			} else {
				stmt.setDate(6, null);
			}
			stmt.setInt(7, ordemServico.getCliente().getId());
			if (endereco == null) {
				stmt.setInt(8, ordemServico.getEndereco().getId());
			} else {
				stmt.setInt(8, endereco.getId());
			}
			stmt.execute();
			ResultSet resultado = stmt.getGeneratedKeys();

			if (resultado.next()) {
				ordemServico.setId(resultado.getInt(1));
			}
			vincularOrdemServicoProfissionais(ordemServico.getId(), ordemServico.getProfissionais());
			vincularOrdemServicoCategoria(ordemServico.getId(), ordemServico.getCategorias());
		} catch (SQLException e) {
			System.out.println(" Erro ao salvar ordem de serviço. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return ordemServico;
	}

	public boolean atualizar(OrdemServico ordemServico) {
		String sql = " UPDATE ORDEM_SERVICO SET numero_os=?, descricao=?, data_cadastro=?, data_inicio=?, data_termino_previsto=?, data_termino=?, id_cliente=?, id_endereco=? "
				+ " WHERE id=?";

		/**
		 * Pega data atual para coluna: data_cadastro
		 */
		java.util.Date dataNova = new java.util.Date();
		String dataCadastro = new SimpleDateFormat("yyy-MM-dd").format(dataNova);
		Connection conexao = Banco.getConnection();

		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco = null;

		if (!verficarOSVinculadaEndereco(ordemServico.getEndereco().getId())) {
			endDAO.atualizar(ordemServico.getEndereco());
		} else {
			endereco = endDAO.salvar(ordemServico.getEndereco());
		}
		int registrosAlterados = 0;
		System.out.println(ordemServico);
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setString(1, ordemServico.getNumeroOS());
			stmt.setString(2, ordemServico.getDescricao());
			stmt.setString(3, dataCadastro);
			stmt.setDate(4, Date.valueOf(ordemServico.getDataInicio()));
			stmt.setDate(5, Date.valueOf(ordemServico.getDataPrevistaFim()));
			if (ordemServico.getDataTermino() != null) {
				stmt.setDate(6, Date.valueOf(ordemServico.getDataTermino()));
			}
			stmt.setInt(7, ordemServico.getCliente().getId());
			if (endereco == null) {
				stmt.setInt(8, ordemServico.getEndereco().getId());
			} else {
				stmt.setInt(8, endereco.getId());
			}
			stmt.setInt(9, ordemServico.getId());
			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(" Erro ao atualizar ordem de serviço. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

//		vincularOrdemServicoProfissionais(ordemServico.getId(), ordemServico.getProfissionais());
//		vincularOrdemServicoCategoria(ordemServico.getId(), ordemServico.getCategorias());

		return registrosAlterados > 0;
	}

	public boolean excluir(int id) {

		String sql = " DELETE FROM ORDEM_SERVICO WHERE id = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			preparedStatement.setInt(1, id);
			int codigoRetornoUpdate = preparedStatement.executeUpdate();

			excluiu = (codigoRetornoUpdate == Banco.CODIGO_RETORNO_SUCESSO_EXCLUSAO);
		} catch (SQLException ex) {
			System.out.println(" Erro ao excluir Ordem de Serviço. Id: " + id + " .Causa: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public OrdemServico consultarPorId(int id) {
		String sql = " SELECT * FROM ORDEM_SERVICO WHERE id = " + id;

		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		OrdemServico ordemServico = null;

		try {
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				ordemServico = construirResultSet(rs);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar Ordem de serviço por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return ordemServico;
	}

	public ArrayList<OrdemServico> listarTodos() {

		String sql = " SELECT * FROM ORDEM_SERVICO ";

		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<OrdemServico> ordemServicos = new ArrayList<OrdemServico>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				OrdemServico ordemServico = construirResultSet(rs);
				ordemServicos.add(ordemServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas as Ordens de Serviço.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return ordemServicos;
	}

	public ArrayList<OrdemServico> listarPorTodosPorNumeroOS(String numeroOS) {

		String sql = " SELECT * FROM ORDEM_SERVICO WHERE numero_os LIKE " + "'%" + numeroOS + "%' ";
		;

		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<OrdemServico> ordemServicos = new ArrayList<OrdemServico>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				OrdemServico ordemServico = construirResultSet(rs);
				ordemServicos.add(ordemServico);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas as Ordens de Serviço pelo Numero.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return ordemServicos;
	}

	private OrdemServico construirResultSet(ResultSet rs) {
		OrdemServico ordemServico = new OrdemServico();

		try {
			ordemServico.setId(rs.getInt("id"));
			ordemServico.setNumeroOS(rs.getString("numero_os"));
			ordemServico.setDescricao(rs.getString("descricao"));
			ordemServico.setDataInicio(rs.getDate("data_inicio").toLocalDate());
			ordemServico.setDataPrevistaFim(rs.getDate("data_termino_previsto").toLocalDate());
			ordemServico.setDataTermino(rs.getDate("data_termino").toLocalDate());

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco end = enderecoDAO.consultarPorId(rs.getInt("id_endereco"));
			ordemServico.setEndereco(end);

			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.consultarPorId(rs.getInt("id_cliente"));
			ordemServico.setCliente(cliente);

		} catch (Exception e) {
			System.out.println("Erro ao construir resultSet Ordem de Serviço. Causa:" + e.getMessage());
		}
		return ordemServico;

	}

	/**
	 * Métodos para tabelas associativas ou validações de dados
	 */
	private void vincularOrdemServicoProfissionais(int idOrdemServico, ArrayList<Profissional> profissionais) {

		for (int i = 0; i < profissionais.size(); i++) {

			String sql = "INSERT INTO  ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional)" + "VALUES (?,?)";

			Connection conexao = Banco.getConnection();

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
			try {
				stmt.setInt(1, idOrdemServico);
				stmt.setInt(2, profissionais.get(i).getId());
				stmt.execute();
			} catch (Exception e) {
				System.out
						.println(" Erro ao salvar vinculo Ordem de Serviço com Profissional. Causa: " + e.getMessage());
			} finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conexao);
			}

		}
	}

	private void vincularOrdemServicoCategoria(int idOrdemServico, ArrayList<Categoria> categorias) {

		for (int i = 0; i < categorias.size(); i++) {

			String sql = "INSERT INTO  ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria)" + "VALUES (?,?)";

			Connection conexao = Banco.getConnection();

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
			try {
				stmt.setInt(1, idOrdemServico);
				stmt.setInt(2, categorias.get(i).getId());
				stmt.execute();
			} catch (Exception e) {
				System.out.println(" Erro ao salvar vinculo Ordem de Serviço com Categoria. Causa: " + e.getMessage());
			} finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conexao);
			}

		}
	}

	public boolean verficarOSVinculadaEndereco(int idEndereco) {

		String sql = " SELECT id FROM ORDEM_SERVICO OS " + " WHERE OS.id_endereco = " + idEndereco;

		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		boolean enderecoVinculado = false;

		try {
			ResultSet rs = stmt.executeQuery();
			enderecoVinculado = rs.next();
		} catch (SQLException e) {
			System.out.println(
					"Erro ao verificar se Endereço está vinculado a alguma Ordem de Serviço. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return enderecoVinculado;
	}

	private boolean verficarOSVinculadaCliente(int idCLiente) {

		String sql = " SELECT id FROM ORDEM_SERVICO OS " + " WHERE OS.id_cliente = " + idCLiente;

		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		boolean clienteVinculado = false;

		try {
			ResultSet rs = stmt.executeQuery();
			clienteVinculado = rs.next();
		} catch (SQLException e) {
			System.out.println(
					"Erro ao verificar se Cliente está vinculado a alguma Ordem de Serviço. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return clienteVinculado;
	}

	public ArrayList<OrdemServico> listarPorSeletor(OrdemServicoSeletor seletor) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM ORDEM_SERVICO AS OS " + " INNER JOIN ORDEM_SERVICO_CATEGORIA AS OSC "
				+ " ON OS.id = OSC.id_categoria ";

		if (seletor.temFiltro()) {
			sql = criarFiltros(sql, seletor);
		}

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<OrdemServico> ordemServicos = new ArrayList<OrdemServico>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				OrdemServico os = construirResultSet(rs);
				ordemServicos.add(os);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar ordem de serviço por seletor.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return ordemServicos;
	}

	private String criarFiltros(String sql, OrdemServicoSeletor seletor) {
		boolean primeiro = true;
		sql += " WHERE ";

		if (seletor.getNumeroOS() != null && !seletor.getNumeroOS().trim().isEmpty()) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " OS.numero_os LIKE " + "'%" + seletor.getNumeroOS() + "%' ";
			primeiro = false;
		}

		if (seletor.getCliente() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " OS.id_cliente = " + seletor.getCliente().getId();
			primeiro = false;
		}

		if (seletor.getCatgoria() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " OSC.id_categoria = " + seletor.getCatgoria().getId();
		}

		return sql;
	}
}
