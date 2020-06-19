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
			return msg = " Ordem de Serviço Salva com sucesso. ";
		} else {
			return msg = " Ocorreu um erro ao salvar Ordem de Serviço. ";
		}
	}

	public ArrayList<OrdemServico> listarClientes(OrdemServicoSeletor seletor) {
		return ordemServicoDAO.listarPorSeletor(seletor);
	}

}
