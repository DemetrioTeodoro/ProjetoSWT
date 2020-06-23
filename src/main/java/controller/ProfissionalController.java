package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.BO.BuscarCep;
import model.BO.ProfissionalBO;
import model.entity.Categoria;
import model.entity.Endereco;
import model.entity.Profissional;
import model.seletor.ProfissionalSeletor;

public class ProfissionalController {

	private ProfissionalBO profBO = new ProfissionalBO();

	public String salvar(String nome, String cpf, boolean ativo, String email, String telefone, String cep, String rua,
			String numero, String bairro, String cidade, String estado, ArrayList<Categoria> categorias) {

		String msg = "";

		if (nome == null || nome.trim().isEmpty()) {
			msg += " Digite o nome. \n";
		}
		if (telefone == null || telefone.trim().isEmpty()) {
			msg += " Digite o telefone. \n";
		}
		if (email == null || email.trim().isEmpty()) {
			msg += " Digite o email. \n";
		}
		if (categorias == null || categorias.size() == 0) {
			msg += " Selecione uma categoria. \n";
		}

		ValidarEnderecoController validarEndereco = new ValidarEnderecoController();
		msg += validarEndereco.validarEndereco(cep, rua, numero, bairro, cidade, estado);

		if (msg.isEmpty()) {

			LocalDate dtcadastro = LocalDate.now();
			Endereco e = new Endereco(rua, numero, bairro, cidade, estado, cep);

			Profissional p = new Profissional();
			p.setNome(nome);
			p.setAtivo(ativo);
			p.setCategorias(categorias);
			p.setDataCadastro(dtcadastro);
			p.setTelefone(telefone);
			p.setEmail(email);
			p.setInscricao(cpf);
			p.setEndereco(e);

			msg = profBO.salvar(p);

			return msg;

		} else {
			return msg;
		}
	}
//Lista todos os profissionais
	public ArrayList<Profissional> listarProfissionais() {
		return profBO.listarProfissionais();
	}
//Lista profissionais pela categoria
	public ArrayList<Profissional> listarProfissionaisPorCategoria(int idCategoria) {
		return profBO.listarProfissionaisPorCategoria(idCategoria);
	}

	public Endereco buscarEnderecoPorCep(String cep) {
		BuscarCep buscarCep = new BuscarCep();
		return buscarCep.buscarCep(cep);
	}
//Lista profissionais ativos pela categoria e disponíveis no periodo
	public ArrayList<Profissional> listarProfissionaisPorCategoria(int idCategoria, LocalDate dataInicio, LocalDate dataPrevistaTermino) {
		
		return profBO.listarProfissionaisPorCategoria(idCategoria,dataInicio,dataPrevistaTermino);
	}
	
	public int buscarQdeOS(int id) {
		return profBO.buscarQdeOS(id);
		
	}
	public ArrayList<Profissional> listarProfissionaisPorSeletor(ProfissionalSeletor seletor) {
		
		return profBO.listarProfissionaisPorSeletor(seletor);
	}

}
