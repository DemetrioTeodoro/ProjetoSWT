package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.Categoria;


public class CategoriaDAO {
	
	public ArrayList<Categoria> listarTodos() {
		String sql = " SELECT * FROM CATEGORIA ";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		try {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Categoria c = new Categoria();
				c.setId(resultSet.getInt("id"));
				c.setNome(resultSet.getString("nome"));
				categorias.add(c);
			}
		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar enderešos. Causa: " + ex.getMessage());
		}
		return categorias;
	}

	public ArrayList<Categoria> consultarCategoriasPorIdProfissional(int idProfissional) {
		String sql = " SELECT * FROM CATEGORIA AS C "+
	                 " INNER JOIN PROFISSIONAL_CATEGORIA AS PC "+
				     " ON C.idcategoria = PC.idcategoria "+
	                 " WHERE PC.id_profissional = ?";
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Categoria categoria = construirResultSet(rs);
				categorias.add(categoria);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar categorias por idprofissional: " + idProfissional);
			System.out.println("Erro: " + e.getMessage());
		}

		return categorias;
	}

	private Categoria construirResultSet(ResultSet rs) {
		Categoria c = new Categoria();
		
		try {
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
				
		}catch (Exception e) {
			System.out.println("Erro ao construir resultSet categoria. Causa:"+ e.getMessage());
		}
		
		return c;
	}
	
}
