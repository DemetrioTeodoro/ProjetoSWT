package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.details.Agenda;
import model.seletor.AgendaSeletor;

public class AgendaDAO {
	
		public ArrayList<Agenda> listarOSAgendaProf(AgendaSeletor seletor) {

			ArrayList<Agenda> agendas = new ArrayList<Agenda>();

			Connection conexao = Banco.getConnection();
			String sql = " SELECT * FROM vlw_agenda AS A " + " INNER JOIN ORDEM_SERVICO_PROFISSIONAL"
					+ " ON A.id = OSP.id_ordem_servico " + " WHERE O.data_termino = null ";

			if (seletor.temFiltro()) {
				sql = criarFiltrosAgenda(sql, seletor);
			}

			sql += " GROUP BY OSP.id_profissional ";

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Agenda agenda = construirResultSetAgenda(rs);
					agendas.add(agenda);
				}

			} catch (SQLException e) {
				System.out.println("Erro ao consultar agenda do profissional." + seletor.getProfissional().toString());
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conexao);
			}

			return agendas;
		}

		public ArrayList<Agenda> listarOSAgenda(AgendaSeletor seletor) {

			ArrayList<Agenda> agendas = new ArrayList<Agenda>();

			Connection conexao = Banco.getConnection();
			String sql = " SELECT * FROM ORDEM_SERVICO AS O " + " INNER JOIN VIEW_AGENDA AS A " + " ON  O.ID = A.Id ";

			if (seletor.temFiltro()) {
				sql = criarFiltrosAgenda(sql, seletor);
			}

			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Agenda agenda = construirResultSetAgenda(rs);
					agendas.add(agenda);
				}

			} catch (SQLException e) {
				System.out.println("Erro ao consultar agenda.");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conexao);
			}

			return agendas;
		}

		private String criarFiltrosAgenda(String sql, AgendaSeletor seletor) {
			if (seletor.getProfissional() == null) {
				sql += " WHERE A.data_inicio BETWEEN '" + seletor.getDataInicio() + "' AND '" + seletor.getDataTermino()
						+ "'" + " OR A.data_termino_previsto BETWEEN '" + seletor.getDataInicio() + "' AND '"
						+ seletor.getDataTermino() + "'" + " OR ISNULL(A.data_termino) AND A.data_inicio < '"
						+ seletor.getDataInicio() + "'"
						+" GROUP BY O.id ";

			} else {
				sql += " INNER JOIN ORDEM_SERVICO_PROFISSIONAL AS OP " + " ON  O.id = OP.id_ordem_servico "
						+ " WHERE A.data_inicio BETWEEN '" + seletor.getDataInicio() + "' AND '" + seletor.getDataTermino()
						+ "'" + " AND OP.id_profissional  = " + seletor.getProfissional().getId()
						+ " OR A.data_termino_previsto BETWEEN '" + seletor.getDataInicio() + "' AND '"
						+ seletor.getDataTermino() + "'" + " AND OP.id_profissional = " + seletor.getProfissional().getId()
						+ " OR ISNULL(A.data_termino) AND A.data_inicio < '" + seletor.getDataInicio() + "'"
						+ " GROUP BY OP.id_profissional ";
			}
			return sql;
		}

		private Agenda construirResultSetAgenda(ResultSet rs) {
			Agenda agenda = new Agenda();

			try {
				agenda.setIdOrdemServico(rs.getInt("id"));
				agenda.setInicio(rs.getDate("data_inicio").toLocalDate());
				agenda.setFim(rs.getDate("data_termino_previsto").toLocalDate());
				agenda.setNumOS(rs.getString("numero_os"));
				agenda.setBairro(rs.getString("bairro"));
				agenda.setCidade(rs.getString("cidade"));
				agenda.setEstado(rs.getString("estado"));
				agenda.setCliente(rs.getString("nome"));
				agenda.setTelCliente(rs.getString("telefone"));

			} catch (Exception e) {
				System.out.println("Erro ao construir resultSet Agenda. Causa:" + e.getMessage());
			}
			return agenda;
		}
		
}
