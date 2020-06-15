package controller;

import model.BO.OrdemServicoBO;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.OrdemServico;
import model.entity.Profissional;

public class OrdemServicoController {

	private OrdemServicoBO ordemServicoBO;
	String msg = "Cadastrado";

	public String cadastrarOS(OrdemServico ordemServico) {
		ordemServicoBO.cadastrarOS(ordemServico);
		System.out.println(ordemServico);
		return msg;
	}
	
	public String cadastrarOS(Cliente selectedItem, String text, String text2, String text3, String text4, String text5,
			String selectedItem2, String text6, Categoria selectedItem3, Profissional selectedItem4, boolean selected) {
		msg = "Chegou no Controller";
		return msg;
	}

}
