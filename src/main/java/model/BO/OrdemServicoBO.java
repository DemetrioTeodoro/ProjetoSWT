package model.BO;

import model.DAO.OrdemServicoDAO;
import model.entity.OrdemServico;

public class OrdemServicoBO {
	
	private OrdemServicoDAO ordemServicoDAO;

	public OrdemServico cadastrarOS(OrdemServico ordemServico) {
		return ordemServicoDAO.salvar(ordemServico);
	}

}
