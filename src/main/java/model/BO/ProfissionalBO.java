package model.BO;

import java.time.LocalDate;
import java.util.ArrayList;

import model.DAO.ProfissionalDAO;
import model.entity.Profissional;
import model.seletor.ProfissionalSeletor;

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

		ArrayList<Profissional> profCategoriaSemOS = new ArrayList<Profissional>();
		profCategoriaSemOS = dao.consultarProfsSemOSPorIdCategoria(idCategoria);

		ArrayList<Profissional> profsDisponiveis = new ArrayList<Profissional>();
		profsDisponiveis = dao.consultarProfsDisponiveisPorIdCategoria(idCategoria, dataInicio, dataPrevistaTermino);

		for (int i = 0; i < profCategoriaSemOS.size(); i++) {
			profsDisponiveis.add(profCategoriaSemOS.get(i));
		}

		return profsDisponiveis;
	}

	public int buscarQdeOS(int id) {

		return dao.buscarQdeOS(id);
	}

	public ArrayList<Profissional> listarProfissionaisPorSeletor(ProfissionalSeletor seletor) {
		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();

		if (!seletor.temFiltro()) {
			profissionais = dao.listarTodos();

		} else {
			if (seletor.getQdeOS() != null) {
				if (seletor.getQdeOS() > 0) {
					profissionais = dao.listarPorSeletor(seletor);
				} else {
					profissionais = dao.listarPorSeletorTodos(seletor);
				}
			} else {
				ArrayList<Profissional> profComOS = new ArrayList<Profissional>();
				profComOS = dao.listarPorSeletor(seletor);
				profissionais = dao.listarPorSeletorTodos(seletor);
				
				for (int i = 0; i < profComOS.size(); i++) {
					Profissional p = profComOS.get(i);
					if (profissionais.contains(p)) {
						System.out.println("Já existe esse profissional na lista");
					} else {
						profissionais.add(p);
					}
				}
			}
		}

		return profissionais;

	}

	public ArrayList<String> buscarCidades() {
		ArrayList<String> cidades = new ArrayList<String>();
		ArrayList<Profissional> profissinais = dao.listarTodos();
		for (int i = 0; i < profissinais.size(); i++) {
			String c = profissinais.get(i).getEndereco().getCidade();
			if (!cidades.contains(c)) {
				cidades.add(profissinais.get(i).getEndereco().getCidade());
			}
		}
		return cidades;
	}

	public Profissional buscarProfissionalPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return dao.buscarProfissionalPorCpf(cpf);
	}
}
