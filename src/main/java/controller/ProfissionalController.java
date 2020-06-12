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
			String numero, String bairro, String cidade, String estado, Categoria categoria) {

		String msg = "";

		// TODO validações dos campos

		ArrayList<Categoria> categorias = new ArrayList<Categoria>(); // ainda tem que fazer vir uma lista de categorias
																		// da tela
		categorias.add(categoria);

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

		profBO.salvar(p);

		return msg;
	}

}
