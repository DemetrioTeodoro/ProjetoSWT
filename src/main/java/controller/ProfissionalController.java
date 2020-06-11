package controller;

import model.BO.ProfissionalBO;
import model.entity.Profissional;

public class ProfissionalController {
	
	private ProfissionalBO profBO = new ProfissionalBO();
	
	public String salvar(Profissional profissional) {
		String msg = "";
		
		//TODO validações dos campos
		
		profBO.salvar(profissional);
				
		return msg;
		
	}

}
