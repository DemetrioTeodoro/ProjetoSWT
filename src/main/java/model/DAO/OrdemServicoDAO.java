package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.entity.Categoria;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;

public class OrdemServicoDAO implements BaseDAO<OrdemServico> {

	@Override
	public OrdemServico salvar(OrdemServico ordemServico) {
		Connection conexao = Banco.getConnection();

		/**
		 * Pega data atual para coluna: data_cadastro
		 */
		java.util.Date dataNova = new java.util.Date();
		String dataCadastro = new SimpleDateFormat("dd/MM/yyyy").format(dataNova);

		Endereco endereco = null;
		if (ordemServico.getEndereco() != null) {
			EnderecoDAO enderecoDAO = new EnderecoDAO();

			endereco = enderecoDAO.salvar(ordemServico.getEndereco());

		}

		String sql = " INSERT INTO ORDEM_SERVICO ( numero, descricao, data_cadastro, data_inicio, data_termino_previsto, data_termino, id_cliente, id_endereco) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setString(1, ordemServico.getNumeroOS());
			stmt.setString(2, ordemServico.getDescricao());
			stmt.setString(3, dataCadastro);
			stmt.setDate(4, Date.valueOf(ordemServico.getDataInicio()));
			stmt.setDate(5, Date.valueOf(ordemServico.getDataPrevistaFim()));
			stmt.setDate(6, Date.valueOf(ordemServico.getDataTermino()));
			stmt.setInt(7, ordemServico.getCliente().getId());
			stmt.setInt(8, endereco.getId());
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet resultado = stmt.getGeneratedKeys();

			if (resultado.next()) {
				ordemServico.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(" Erro ao salvar ordem de serviço. Causa: " + e.getMessage());
		}

		vincularOrdemServicoProfissionais(ordemServico.getId(), ordemServico.getProfissionais());
		vincularOrdemServicoCategoria(ordemServico.getId(), ordemServico.getCategorias());

		return ordemServico;
	}

	private void vincularOrdemServicoProfissionais(int idOrdemServico, ArrayList<Profissional> profissionais) {

		for (int i = 0; i < profissionais.size(); i++) {

			Connection conexao = Banco.getConnection();
			String sql = "INSERT INTO  ORDEM_SERVICO_PROFISSIONAL (id_ordem_servico, id_profissional)" + "VALUES (?,?)";

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
			try {
				stmt.setInt(1, idOrdemServico);
				stmt.setInt(2, profissionais.get(i).getId());

			} catch (Exception e) {
				System.out.println(" Erro ao salvar vinculo ordem de serviço com profissional. Causa: " + e.getMessage());
			}

		}
	}

	private void vincularOrdemServicoCategoria(int idOrdemServico, ArrayList<Categoria> categorias) {

		for (int i = 0; i < categorias.size(); i++) {

			Connection conexao = Banco.getConnection();
			String sql = "INSERT INTO  ORDEM_SERVICO_CATEGORIA (id_ordem_servico, id_categoria)" + "VALUES (?,?)";

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
			try {
				stmt.setInt(1, idOrdemServico);
				stmt.setInt(2, categorias.get(i).getId());

			} catch (Exception e) {
				System.out.println(" Erro ao salvar vinculo ordem de serviço com categoria. Causa: " + e.getMessage());
			}

		}
	}

	@Override
	public boolean atualizar(OrdemServico ordemServico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrdemServico consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrdemServico> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
