package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.Cliente;

public class ClienteDAO implements BaseDAO<Cliente> {

	public Cliente salvar(Cliente cliente) {
		Connection conexao = Banco.getConnection();

		String sql = " INSERT INTO CLIENTE ( nome, inscricao, cpf, ativo, data_cadastro, telefone, email) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getInscricao());
			stmt.setBoolean(3, cliente.isEhCpf());
			stmt.setBoolean(4, cliente.isAtivo());
			stmt.setDate(5, Date.valueOf(cliente.getDataCadastro()));
			stmt.setInt(6, Integer.parseInt(cliente.getTelefone()));
			stmt.setString(7, cliente.getEmail());
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet resultado = stmt.getGeneratedKeys();

			if (resultado.next()) {
				cliente.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(" Erro ao salvar cliente. Causa: " + e.getMessage());
		}
		return cliente;
	}

	public boolean atualizar(Cliente cliente) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE CLIENTE SET nome=?, inscricao=?, cpf=?, ativo=?, data_cadastro=?, telefone=? email=? WHERE id = ?";
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
			System.out.println(" Erro ao consultar endereço. Id: " + id + " .Causa: " + ex.getMessage());
		}
		return clienteConsultado;
	}

	public ArrayList<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	private Cliente construirClienteDoResultSet(ResultSet conjuntoResultante) {
		Cliente cliente = new Cliente();
		try {
			cliente.setId(conjuntoResultante.getInt("id"));
			cliente.setNome(conjuntoResultante.getString("nome"));
			cliente.setInscricao(conjuntoResultante.getString("inscricao"));
			cliente.setEhCpf(conjuntoResultante.getBoolean("cpf"));
			cliente.setAtivo(conjuntoResultante.getBoolean("ativo"));
			cliente.setDataCadastro(LocalDate.parse((CharSequence) conjuntoResultante.getDate("data_cadastro")));
			cliente.setTelefone(conjuntoResultante.getString("telefone"));
			cliente.setEmail(conjuntoResultante.getString("email"));
		} catch (SQLException ex) {
			System.out.println(" Erro ao construir cliente a partir do ResultSet. Causa: " + ex.getMessage());
		}
		return cliente;
	}

}
