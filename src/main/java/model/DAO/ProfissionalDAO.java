package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.entity.Endereco;
import model.entity.Profissional;

public class ProfissionalDAO implements BaseDAO<Profissional>{

	public Profissional salvar(Profissional profissional) {
		//Primeiro salvar o endereço para gerar o idEndereco
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco = endDAO.salvar(profissional.getEndereco());
		
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PROFISSIONAL (nome, cpf, telefone, email, data_cadastro, ativo, id_endereco) " + " VALUES (?,?,?,?,?,?,?) ";
		
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, profissional.getNome());
			stmt.setString(2, profissional.getInscricao());
			stmt.setString(3, profissional.getTelefone());
			stmt.setString(4, profissional.getEmail());
			stmt.setDate(5, java.sql.Date.valueOf(profissional.getDataCadastro()));
			stmt.setBoolean(6, profissional.isAtivo());
			stmt.setInt(7, endereco.getId());
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
		
			if (rs.next()) {
				profissional.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(" Erro ao salvar profissional. Causa: " + e.getMessage());
		}
		return profissional;
	}
	
	private void salvarEndereco(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	public boolean atualizar(Profissional profissional) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Profissional consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Profissional> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
