package controller;

import java.time.LocalDate;

import model.BO.ClienteBO;
import model.entity.Cliente;
import model.entity.Endereco;

public class ClienteController {
	
	private ClienteBO bo = new ClienteBO();

	public String salvar(String inscricao, String nome, boolean Cpf, boolean Cnpj, boolean ativo, String tel, String email, 
			String cep, String rua, String numero, String bairro, String cidade, String estado) {
			
		String msg="";
		
		// TODO validações
		
		LocalDate dtcadastro = LocalDate.now();
		boolean ehCpf = false;
		
		if (Cpf) {
			ehCpf = true;
		}
		
		Endereco e = new Endereco(rua, numero, bairro, cidade, estado, cep);
		Cliente cliente = new Cliente();
		cliente.setInscricao(inscricao);
		cliente.setNome(nome);
		cliente.setAtivo(ativo);
		cliente.setDataCadastro(dtcadastro);
		cliente.setEhCpf(ehCpf);
		cliente.setEmail(email);
		cliente.setTelefone(tel);
		cliente.setEndereco(e);
		
		msg = bo.salvar(cliente);
		
		
		
		return msg;
	}

}
