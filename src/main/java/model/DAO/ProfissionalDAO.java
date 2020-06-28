package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.Categoria;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;
import model.seletor.OrdemServicoSeletor;
import model.seletor.ProfissionalSeletor;

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
			vincularProfissionalCategoria(profissional);

		} catch (SQLException e) {
			System.out.println(" Erro ao salvar profissional. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(stmt);
		}
		return profissional;
	}

	private void vincularProfissionalCategoria(Profissional profissional) {

		for (int i = 0; i < profissional.getCategorias().size(); i++) {

			Connection conexao = Banco.getConnection();
			String sql = "INSERT INTO  PROFISSIONAL_CATEGORIA (id_profissional, id_categoria)" + "VALUES (?,?)";

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
			try {
				stmt.setInt(1, profissional.getId());
				stmt.setInt(2, profissional.getCategorias().get(i).getId());
				stmt.execute();

			} catch (Exception e) {
				System.out.println(" Erro ao salvar vinculo profissional x categoria. Causa: " + e.getMessage());

			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conexao);
				Banco.closePreparedStatement(stmt);
			}
		}

	}

	public boolean atualizar(Profissional profissional) {

		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco = null;
		OrdemServicoDAO osDAo = new OrdemServicoDAO();

		desVincularProfissionalCategoria(profissional.getId());

		vincularProfissionalCategoria(profissional);

		if (!osDAo.verficarOSVinculadaEndereco(profissional.getEndereco().getId())) {
			endereco = profissional.getEndereco();

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
			stmt.setInt(8, profissional.getId());

			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar dados do profissional.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return registrosAlterados > 0;
	}

	private void desVincularProfissionalCategoria(int idProfissional) {

		Connection conexao = Banco.getConnection();
		
		String sql = " DELETE FROM  PROFISSIONAL_CATEGORIA 	WHERE id_profissional = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao,sql);

		try {
			stmt.setInt(1, idProfissional);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(" Erro ao excluir vinculo profissional x categoria. Causa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
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
			System.out.println(
					"Erro ao verificar se profissional está vinculado a alguma Categoria. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
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
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
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
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return profissionais;
	}

	public boolean excluir(int id) {
		// Profissionais serão apenas desativados no Cadastro ou Edição.
		return false;
	}

	public ArrayList<Profissional> consultarProfissionalPorIdCategoria(int idCategoria) {

		String sql = " SELECT * FROM PROFISSIONAL AS P " + " INNER JOIN PROFISSIONAL_CATEGORIA AS PC "
				+ " ON P.id = PC.id_profissional " + " WHERE PC.id_categoria = " + idCategoria;

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();

		try {
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Profissional profissional = construirResultSet(rs);
				profissionais.add(profissional);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar profissionais por idCategoria: " + idCategoria);
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return profissionais;
	}

	// MÉTODO TRAZ PROFISSIONAIS COM 'OS' EM ADAMENTO PORÉM DISPONÍVEIS NO PERIODO
	// DA NOVA OS REFERENTE A CATEGORIA SELECIONADA.
	public ArrayList<Profissional> consultarProfsDisponiveisPorIdCategoria(int idCategoria, LocalDate dtInicio,
			LocalDate dtfimprevisto) {

		String sql = " SELECT DISTINCT * FROM PROFISSIONAL AS P " + " INNER JOIN ORDEM_SERVICO_PROFISSIONAL AS OP "
				+ " ON P.id =  OP.id_profissional " + " INNER JOIN  ORDEM_SERVICO AS O "
				+ " ON O.id = OP.id_ordem_servico " + " INNER JOIN PROFISSIONAL_CATEGORIA AS PC "
				+ " ON P.id = PC.id_profissional " + " WHERE PC.id_categoria = " + idCategoria + " AND P.ativo = TRUE "
				+ " AND '" + dtInicio + "' NOT BETWEEN O.data_inicio AND O.data_termino_previsto " + " AND '"
				+ dtfimprevisto + "' NOT BETWEEN O.data_inicio AND O.data_termino_previsto "
				+ " AND O.data_inicio  NOT BETWEEN '" + dtInicio + "' AND '" + dtfimprevisto + "' "
				+ " AND O.data_termino_previsto NOT BETWEEN '2020-06-24' AND '2020-06-30' " + " GROUP BY P.ID ";

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();

		try {
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Profissional profissional = construirResultSet(rs);
				profissionais.add(profissional);
			}

		} catch (SQLException e) {
			System.out.println(
					"Erro ao consultar profissionais ativos, com OS associadas, disponíveis no periodo por idCategoria: "
							+ idCategoria);
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return profissionais;
	}

	// MÉTODO TRAZ PROFISSIONAIS ATIVOS SEM OS VINCULADA REFERENTE A CATEGORIA
	// SELECIONADA.
	public ArrayList<Profissional> consultarProfsSemOSPorIdCategoria(int idCategoria) {

		String sql = " SELECT DISTINCT * FROM PROFISSIONAL P " + " INNER JOIN PROFISSIONAL_CATEGORIA PC "
				+ " ON P.id = PC.id_profissional " + " LEFT JOIN ORDEM_SERVICO_PROFISSIONAL OP "
				+ " ON P.id = OP.id_profissional " + " WHERE P.ATIVO = TRUE AND PC.id_categoria = " + idCategoria
				+ " AND P.id NOT IN (SELECT DISTINCT id_profissional  FROM ORDEM_SERVICO_PROFISSIONAL) "
				+ " GROUP BY P.ID";

		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();

		try {
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Profissional profissional = construirResultSet(rs);
				profissionais.add(profissional);
			}

		} catch (SQLException e) {
			System.out.println(
					"Erro ao consultar profissionais ativos por idCategoria (" + idCategoria + ") sem OS vinculada. ");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return profissionais;
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
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return cpfUsado;
	}

	// BUSCAR POR SELETOR Profissionais com OS VINCULADA
	public ArrayList<Profissional> listarPorSeletor(ProfissionalSeletor seletor) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT DISTINCT * FROM PROFISSIONAL P " + " INNER JOIN PROFISSIONAL_CATEGORIA PC "
				+ " ON P.id = PC.id_profissional " + " INNER JOIN CATEGORIA C " + " ON PC.id_categoria = C.id "
				+ " LEFT JOIN ORDEM_SERVICO_PROFISSIONAL OP " + " ON P.id = OP.id_profissional "
				+ " INNER JOIN  ORDEM_SERVICO AS O " + " ON O.id = OP.id_ordem_servico " + " INNER JOIN  ENDERECO AS E "
				+ " ON E.id = P.id_endereco " + " RIGHT JOIN VIEW_PROFISSIONAL_QDE_OS POS " + " ON P.ID = POS.ID ";

		if (seletor.temFiltro()) {
			sql = criarFiltros(sql, seletor);
		}

		sql += " GROUP BY P.ID ";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Profissional p = construirResultSet(rs);
				profissionais.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar profissionais por seletor.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return profissionais;
	}

	private String criarFiltros(String sql, ProfissionalSeletor seletor) {
		boolean primeiro = true;
		sql += " WHERE ";

		if (seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " P.nome LIKE " + "'%" + seletor.getNome() + "%' ";
			primeiro = false;
		}

		if (seletor.getCategoria() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " C.id = " + seletor.getCategoria().getId();
			primeiro = false;
		}

		if (seletor.getCidade() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " E.cidade = '" + seletor.getCidade() + "'";
			primeiro = false;
		}
		if (seletor.getQdeOS() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " POS.QDE_OS = " + seletor.getQdeOS();
			primeiro = false;
		}

		return sql;
	}

	// BUSCAR POR SELETOR TODOS PROFISSIONAIS
	public ArrayList<Profissional> listarPorSeletorTodos(ProfissionalSeletor seletor) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT DISTINCT * FROM PROFISSIONAL P " + " INNER JOIN PROFISSIONAL_CATEGORIA PC "
				+ " ON P.id = PC.id_profissional " + " INNER JOIN CATEGORIA C " + " ON PC.id_categoria = C.id "
				+ " INNER JOIN  ENDERECO AS E " + " ON E.id = P.id_endereco "
				+ " RIGHT JOIN VIEW_PROFISSIONAL_QDE_OS POS " + " ON P.ID = POS.ID ";

		if (seletor.temFiltro()) {
			sql = criarFiltros2(sql, seletor);
		}

		sql += " GROUP BY P.ID ";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Profissional p = construirResultSet(rs);
				profissionais.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar profissionais sem OS por seletor.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return profissionais;
	}

	private String criarFiltros2(String sql, ProfissionalSeletor seletor) {
		boolean primeiro = true;
		sql += " WHERE ";

		if (seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " P.nome LIKE " + "'%" + seletor.getNome() + "%' ";
			primeiro = false;
		}

		if (seletor.getCategoria() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " C.id = " + seletor.getCategoria().getId();
			primeiro = false;
		}

		if (seletor.getCidade() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " E.cidade '" + seletor.getCidade() + "'";
			primeiro = false;
		}
		if (seletor.getQdeOS() != null) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " POS.qde_os = " + seletor.getQdeOS();
			primeiro = false;
		}
		return sql;
	}

	// MÉTODO PARA BUSCAR QDE DE OS PELO ID DO PROFISSIONAL PARA POPULAR A TABELA
	// LISTAGEM DE PROFISSIONAL
	public int buscarQdeOS(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT qde_os FROM VIEW_PROFISSIONAL_QDE_OS WHERE id = " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		int qdeOS = 0;

		try {
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				qdeOS = rs.getInt("QDE_OS");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar qde de OS x profissiona (" + id + ")");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return qdeOS;
	}

	public Profissional buscarProfissionalPorCpf(String cpf) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PROFISSIONAL WHERE cpf = '" + cpf + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		Profissional profissional = null;

		try {
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				profissional = construirResultSet(rs);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar profissional por cpf = " + cpf);
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return profissional;
	}

}
