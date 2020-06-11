package model.BO;

import model.DAO.ProfissionalDAO;
import model.entity.Profissional;

public class ProfissionalBO {

	private ProfissionalDAO dao = new ProfissionalDAO();

	public String salvar(Profissional profissional) {
		String msg = "";
		
		if (dao.cpfJaUtilizado(profissional.getInscricao())) {
			
			msg = "CPF informado (" + profissional.getInscricao() + ")j� utilizado.";
		
		} else {
			
			if (profissional.getId() > 0) {
				if (dao.atualizar(profissional)) {
					msg = "Atualiza��o realizada com sucesso";
				} else {
					msg = "Erro ao atualizar profissional";
				}
			} else {
				Profissional p = dao.salvar(profissional);
				if (p.getId() > 0) {
					msg = "Cadastro realizado com sucesso";
				} else {
					msg = "Erro ao cadastrar profissional";
				}
			}
		}
		return msg;
	}
	
	
	
	
}
