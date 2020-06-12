package controller;

import model.BO.OrdemServicoBO;
import model.entity.OrdemServico;

public class OrdemServicoController {

	private OrdemServicoBO ordemServicoBO;

	public OrdemServico cadastrarOS(OrdemServico ordemServico) {
		return ordemServicoBO.cadastrarOS(ordemServico);
	}

}
