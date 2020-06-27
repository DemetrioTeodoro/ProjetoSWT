package model.BO;

import java.util.ArrayList;

import model.DAO.OrdemServicoDAO;
import model.details.Agenda;
import model.entity.OrdemServico;
import model.seletor.AgendaSeletor;
import model.seletor.OrdemServicoSeletor;

public class OrdemServicoBO {
	
	private OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
	private String msg = "";
	
	public String cadastrarOS(OrdemServico ordemServico) {
		OrdemServico os = new OrdemServico();
		os = ordemServicoDAO.salvar(ordemServico);
		if (os != null) {
			 msg= " Ordem de Serviço salva com sucesso. ";
		} else {
			 msg= " Ocorreu um erro ao salvar Ordem de Serviço. ";
		}
		return msg;
	}

	public ArrayList<OrdemServico> listarClientes(OrdemServicoSeletor seletor) {
		
		if (seletor.getCatgoria() == null && seletor.getCliente() == null && !seletor.getNumeroOS().trim().isEmpty()) {
			return ordemServicoDAO.listarPorTodosPorNumeroOS(seletor.getNumeroOS());
		}
		
		if (seletor.getCatgoria() != null && seletor.getCliente() != null && !seletor.getNumeroOS().trim().isEmpty()) {
			System.out.println(seletor);
			return ordemServicoDAO.listarPorSeletor(seletor);			
		} else {
			return ordemServicoDAO.listarTodos();
		}
	}

	public ArrayList<OrdemServico> listarTodos() {
		return ordemServicoDAO.listarTodos();
	}

	public String atualizar(OrdemServico os) {
		boolean atualizadp = ordemServicoDAO.atualizar(os);
		if (atualizadp) {
			msg = " Ordem de Serviço atualizado! ";
		} else if (atualizadp == false) {
			msg = " Ordem de Serviço não atualizado! ";
		} else {
			msg = " Ocorreu um erro ao atualizar Ordem de Serviço ";
		}
		return msg;
	}

}
