package model.BO;

import model.DAO.OrdemServicoDAO;
import model.entity.OrdemServico;

public class OrdemServicoBO {
	
	private OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();

	public OrdemServico cadastrarOS(OrdemServico ordemServico) {
		return ordemServicoDAO.salvar(ordemServico);
	}

}
