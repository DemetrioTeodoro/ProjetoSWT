package model.BO;

import java.util.ArrayList;

import model.DAO.OrdemServicoDAO;
import model.entity.OrdemServico;
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

}
