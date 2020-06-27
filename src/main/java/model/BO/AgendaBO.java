package model.BO;

import java.util.ArrayList;

import model.DAO.AgendaDAO;
import model.details.Agenda;
import model.seletor.AgendaSeletor;

public class AgendaBO {
	
	private AgendaDAO dao = new AgendaDAO();

	public ArrayList<Agenda> listarOSAgenda(AgendaSeletor seletor) {
		return dao.listarOSAgenda(seletor);
	}

}
