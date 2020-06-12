package controller;

import model.BO.OrdemServicoBO;
import model.entity.OrdemServico;

public class OrdemServicoController {

	private OrdemServicoBO ordemServicoBO;
String msg = "Cadastrado";
	public String cadastrarOS(OrdemServico ordemServico) {
		ordemServicoBO.cadastrarOS(ordemServico);
		return msg;
	}

}
