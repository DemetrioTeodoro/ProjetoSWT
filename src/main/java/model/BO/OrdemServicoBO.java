package model.BO;

import model.DAO.OrdemServicoDAO;
import model.entity.OrdemServico;

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

}
