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
			 msg= " Ordem de serviço salva com sucesso. ";
		} else {
			 msg= " Ocorreu um erro ao tentar salvar a ordem de serviço. ";
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
		boolean atualizado = ordemServicoDAO.atualizar(os);
		if (atualizado) {
			msg = " Ordem de Serviço atualizado! ";
		} else if (atualizado == false) {
			msg = " Ordem de Serviço não atualizado! ";
		} else {
			msg = " Ocorreu um erro ao atualizar Ordem de Serviço ";
		}
		return msg;
	}

	public String excluir(OrdemServico os) {
		boolean excluido =  ordemServicoDAO.excluir(os);
		if (excluido) {
			msg = " Ordem de Serviço excluida! ";
		} else if (excluido == false) {
			msg = " Ordem de Serviço não excluida! ";
		} else {
			msg = " Ocorreu um erro ao excluir Ordem de Serviço ";
		}
		return msg;

	}

	public boolean jaTemNumeroOS(String numOS) {
		return ordemServicoDAO.jaTemNumeroOS(numOS);
	}

}
