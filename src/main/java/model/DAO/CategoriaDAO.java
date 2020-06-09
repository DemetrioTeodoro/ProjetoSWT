package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			System.out.println(" Erro ao consultar endereços. Causa: " + ex.getMessage());
		}
		return categorias;
	}

}
