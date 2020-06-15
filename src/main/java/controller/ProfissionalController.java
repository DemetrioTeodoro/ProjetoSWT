package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.BO.ProfissionalBO;
import model.entity.Categoria;
import model.entity.Endereco;
import model.entity.Profissional;

public class ProfissionalController {

	private ProfissionalBO profBO = new ProfissionalBO();

	public String salvar(String nome, String cpf, boolean ativo, String email, String telefone, String cep, String rua,
			String numero, String bairro, String cidade, String estado, ArrayList<Categoria> categorias) {

		String msg = "";

		if (nome == null || nome.isEmpty()) {
			msg += " Digite o nome. \n";
		}
		if (telefone == null || telefone.isEmpty()) {
			msg += " Digite o telefone. \n";
		}
		if (email == null || email.isEmpty()) {
			msg += " Digite o email. \n";
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

	public ArrayList<Profissional> listarProfissionais() {
		return profBO.listarProfissionais();
	}

	public ArrayList<Profissional> listarProfissionaisPorCategoria(int idCategoria) {
		return profBO.listarProfissionaisPorCategoria(idCategoria);
	}

}
