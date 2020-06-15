package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.BO.OrdemServicoBO;
import model.entity.Categoria;
import model.entity.Cliente;
<<<<<<< HEAD
=======
import model.entity.Endereco;
>>>>>>> branch 'master' of https://github.com/DemetrioProgram/ProjetoSWT.git
import model.entity.OrdemServico;
import model.entity.Profissional;

public class OrdemServicoController {
	
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	ArrayList<Profissional> pros = new ArrayList<Profissional>();

<<<<<<< HEAD
	private OrdemServicoBO ordemServicoBO;
	String msg = "Cadastrado";

=======
	private OrdemServicoBO ordemServicoBO = new OrdemServicoBO();
String msg = "Cadastrado";
>>>>>>> branch 'master' of https://github.com/DemetrioProgram/ProjetoSWT.git
	public String cadastrarOS(OrdemServico ordemServico) {
		ordemServicoBO.cadastrarOS(ordemServico);
		System.out.println(ordemServico);
		return msg;
	}
<<<<<<< HEAD
	
	public String cadastrarOS(Cliente selectedItem, String text, String text2, String text3, String text4, String text5,
			String selectedItem2, String text6, Categoria selectedItem3, Profissional selectedItem4, boolean selected) {
		msg = "Chegou no Controller";
		return msg;
	}

=======
	public String cadastrarOS(Cliente cliente, String cep, String estado, String cidade, String bairro, String rua,
			String numero, String descricao, LocalDate dataInicial, LocalDate dataFinal, Categoria categoria, Profissional profissional) {
		
		Endereco end = new Endereco();
		end.setCep(cep);
		end.setEstado(estado);
		end.setBairro(bairro);
		end.setRua(rua);
		end.setNumero(numero);		
		end.setCidade(cidade);
		
		Profissional p = new Profissional();
		System.out.println(profissional);
		pros.add(profissional);
		System.out.println(pros);
		
		OrdemServico os = new OrdemServico();
		categorias.add(categoria);
		os.setCategorias(categorias);
		os.setProfissionais(pros);
		os.setCliente(cliente);
		os.setDataInicio(dataInicial);
		os.setDataPrevistaFim(dataInicial);
		os.setDataTermino(dataInicial);
		os.setDescricao(descricao);
		os.setEndereco(end);
		os.setNumeroOS("1");
		
		
		System.out.println(os);
		ordemServicoBO.cadastrarOS(os);
		return msg;
	}
	
>>>>>>> branch 'master' of https://github.com/DemetrioProgram/ProjetoSWT.git
}
