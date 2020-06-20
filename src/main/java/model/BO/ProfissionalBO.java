package model.BO;

import java.time.LocalDate;
import java.util.ArrayList;

import model.DAO.ProfissionalDAO;
import model.entity.Profissional;

public class ProfissionalBO {

	private ProfissionalDAO dao = new ProfissionalDAO();

	public String salvar(Profissional profissional) {
		String msg = "";
		
		if (dao.cpfJaUtilizado(profissional.getInscricao())) {
			
			msg = "CPF informado (" + profissional.getInscricao() + ")já utilizado.";
		
		} else {
			
			if (profissional.getId() > 0) {
				if (dao.atualizar(profissional)) {
					msg = "Atualização realizada com sucesso";
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

	public ArrayList<Profissional> listarProfissionais() {
		return dao.listarTodos();
	}

	public ArrayList<Profissional> listarProfissionaisPorCategoria(int idCategoria) {
		return dao.consultarProfissionalPorIdCategoria(idCategoria);
	}

	public ArrayList<Profissional> listarProfissionaisPorCategoria(int idCategoria, LocalDate dataInicio,
			LocalDate dataPrevistaTermino) {
		
		ArrayList<Profissional>profCategoriaSemOS = new ArrayList<Profissional>();
		profCategoriaSemOS = dao.consultarProfsSemOSPorIdCategoria(idCategoria);
		
		ArrayList<Profissional>profsDisponiveis = new ArrayList<Profissional>();
		profsDisponiveis = dao.consultarProfsDisponiveisPorIdCategoria(idCategoria, dataInicio, dataPrevistaTermino);
		
		for(int i = 0; i< profCategoriaSemOS.size(); i++) {
			profsDisponiveis.add(profCategoriaSemOS.get(i));
		}
		
		return profsDisponiveis;
	}
		
}
