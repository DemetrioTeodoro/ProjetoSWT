package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Categoria;
import model.entity.Endereco;
import model.entity.Profissional;

public class ProfissionalDAO implements BaseDAO<Profissional> {

	public Profissional salvar(Profissional profissional) {

		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco = endDAO.salvar(profissional.getEndereco());

		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PROFISSIONAL (nome, cpf, telefone, email, data_cadastro, ativo, id_endereco) "
				+ " VALUES (?,?,?,?,?,?,?) ";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, profissional.getNome());
			stmt.setString(2, profissional.getInscricao());
			stmt.setString(3, profissional.getTelefone());
			stmt.setString(4, profissional.getEmail());
			stmt.setDate(5, Date.valueOf(profissional.getDataCadastro()));
			stmt.setBoolean(6, profissional.isAtivo());
			stmt.setInt(7, endereco.getId());
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				profissional.setId(rs.getInt(1));
			}
			vincularProfissionalCategoria(profissional.getId(), profissional.getCategorias());

		} catch (SQLException e) {
			System.out.println(" Erro ao salvar profissional. Causa: " + e.getMessage());
		}

		return profissional;
	}

	private void vincularProfissionalCategoria(int idProfissional, ArrayList<Categoria> categorias) {

		for (int i = 0; i < categorias.size(); i++) {

			Connection conexao = Banco.getConnection();
			String sql = "INSERT INTO  PROFISSIONAL_CATEGORIA (id_profissional, id_categoria)" + "VALUES (?,?)";

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
			try {
				stmt.setInt(1, idProfissional);
				stmt.setInt(2, categorias.get(i).getId());
				stmt.execute();

			} catch (Exception e) {
				System.out.println(" Erro ao salvar vinculo profissional x categoria. Causa: " + e.getMessage());

			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conexao);
			}

		}
	}

	public boolean atualizar(Profissional profissional) {
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco = null;

		if (!verficarOSVinculadaEndereco(profissional.getEndereco().getId())) {
			endDAO.atualizar(profissional.getEndereco());
		} else {
			endereco = endDAO.salvar(profissional.getEndereco());
		}

		Connection conexao = Banco.getConnection();
		String sql = " UPDATE PROFISSIONAL SET nome=?, cpf=?, telefone=?, email=?, data_cadastro=?, ativo=?, id_endereco=? WHERE id = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		int registrosAlterados = 0;

		try {
			stmt.setString(1, profissional.getNome());
			stmt.setString(2, profissional.getInscricao());
			stmt.setString(3, profissional.getTelefone());
			stmt.setString(4, profissional.getEmail());
			stmt.setDate(5, Date.valueOf(profissional.getDataCadastro()));
			stmt.setBoolean(6, profissional.isAtivo());
			if (endereco == null) {
				stmt.setInt(7, profissional.getEndereco().getId());
			} else {
				stmt.setInt(7, endereco.getId());
			}

			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar dados do proffisional.");
			System.out.println("Erro: " + e.getMessage());
		}

		return registrosAlterados > 0;
	}

	// PASSAR O MÉTODO PARA A OrdemServicoDAO
	private boolean verficarOSVinculadaEndereco(int idEndereco) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT id FROM ORDEMSERVICO OS " + " WHERE OS.id_endereco = " + idEndereco;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		boolean enderecoVinculado = false;

		try {
			ResultSet rs = stmt.executeQuery();
			enderecoVinculado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se endereço está vinculado a alguma OS. Causa: " + e.getMessage());
		}

		return enderecoVinculado;
	}
	
	public ArrayList<Profissional> verficarProfissionalPorCategoria(int idCategoria) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT id FROM PROFISSIONAL_CATEGORIA " + " WHERE id_categoria = " + idCategoria;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Profissional p = construirResultSet(rs);
				profissionais.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se profissional está vinculado a alguma Categoria. Causa: " + e.getMessage());
		}

		return profissionais;
	}

	public Profissional consultarPorId(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PROFISSIONAL WHERE id = " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		Profissional profissional = null;

		try {
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				profissional = construirResultSet(rs);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar profissional por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}

		return profissional;
	}

	private Profissional construirResultSet(ResultSet rs) {
		Profissional p = new Profissional();

		try {
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setInscricao(rs.getString("cpf"));
			p.setTelefone(rs.getString("telefone"));
			p.setEmail(rs.getString("email"));
			p.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
			p.setAtivo(rs.getBoolean("ativo"));

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco end = enderecoDAO.consultarPorId(rs.getInt("id_endereco"));
			p.setEndereco(end);

			CategoriaDAO categoriaDAO = new CategoriaDAO();
			ArrayList<Categoria> categorias = categoriaDAO.consultarCategoriasPorIdProfissional(rs.getInt("id"));
			p.setCategorias(categorias);

		} catch (Exception e) {
			System.out.println("Erro ao construir resultSet profissional. Causa:" + e.getMessage());
		}
		return p;

	}

	public ArrayList<Profissional> listarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PROFISSIONAL P ";

		/*
		 * if (seletor.temFiltro()) { sql = criarFiltros(sql, seletor); }
		 */

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Profissional p = construirResultSet(rs);
				profissionais.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar profissionais.");
			System.out.println("Erro: " + e.getMessage());
		}
		return profissionais;
	}

	public boolean excluir(int id) {
		// Profissionais serão apenas desativados no Cadastro ou Edição.
		return false;
	}

	public boolean cpfJaUtilizado(String cpf) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PROFISSIONAL P " + " WHERE P.cpf = '" + cpf + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		boolean cpfUsado = false;

		try {
			ResultSet rs = stmt.executeQuery();
			cpfUsado = rs.next();

		} catch (Exception e) {
			System.out.println("Erro ao verificar se o cpf já está sendo utilizado.Causa:" + e.getMessage());
		}

		return cpfUsado;
	}

}
