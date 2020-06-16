package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.BO.BuscarCep;
import model.BO.OrdemServicoBO;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;

public class OrdemServicoController {

	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	ArrayList<Profissional> pros = new ArrayList<Profissional>();

	private OrdemServicoBO ordemServicoBO = new OrdemServicoBO();
	String msg = "";

	public String cadastrarOS(OrdemServico ordemServico) {
		ordemServicoBO.cadastrarOS(ordemServico);
		System.out.println(ordemServico);
		return msg;
	}

	/*public String cadastrarOS(Cliente cliente, String cep, String estado, String cidade, String bairro, String rua,
			String numero, String descricao, LocalDate dataInicial, LocalDate dataFinal, Categoria categoria,
			Profissional profissional) {

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
	}*/

	public String cadastrarOS(String numeroOS, String estado, String cidade, String numero, String rua, String bairro,
			String cep, LocalDate dataInicial, LocalDate dataFinal, String descricao, Cliente cliente,
			ArrayList<Categoria> categoria, ArrayList<Profissional> profissionais) {

		if (numeroOS == null || numeroOS.trim().isEmpty()) {
			msg += " Digite o numero da Ordem de Serviço. \\n";
		}
		if (cliente == null) {
			msg += " Selecione um cliente. \n";
		}
		if (categoria == null || categoria.size() == 0) {
			msg += " Selecione uma categoria. \n";
		}
		if (profissionais == null || profissionais.size() == 0) {
			msg += " Selecione um profissional. \n";
		}
		if (descricao == null || descricao.trim().isEmpty()) {
			msg += " Digite a descrição. \n";
		}
		if (dataFinal == null) {
			msg += " Digite a data final. \n";
		}
		if (dataInicial == null) {
			msg += " Digite a data inicial. \n";
		}
		if (dataInicial != null && dataFinal != null) {
			if (dataInicial.isAfter(dataFinal)) {
				msg += " A data Inicial deve ser menor que a data Final \n";
			}
		}


		ValidarEnderecoController validarEndereco = new ValidarEnderecoController();
		msg += validarEndereco.validarEndereco(cep, rua, numero, bairro, cidade, estado);

		if (msg.isEmpty()) {

			Endereco end = new Endereco();
			end.setCep(cep);
			end.setEstado(estado);
			end.setBairro(bairro);
			end.setRua(rua);
			end.setNumero(numero);
			end.setCidade(cidade);

			Profissional p = new Profissional();
			System.out.println(profissionais);

			OrdemServico os = new OrdemServico();
			os.setCategorias(categoria);
			os.setProfissionais(profissionais);
			os.setCliente(cliente);
			os.setDataInicio(dataInicial);
			os.setDataPrevistaFim(dataInicial);
			os.setDataTermino(dataInicial);
			os.setDescricao(descricao);
			os.setEndereco(end);
			os.setNumeroOS(numeroOS);

			System.out.println(os);
			msg = ordemServicoBO.cadastrarOS(os);
			return msg;

		} else {
			return msg;
		}
	}

	public Endereco buscarEnderecoPorCep(String cep) {
		BuscarCep buscarCep = new BuscarCep();
		return buscarCep.buscarCep(cep);
	}

}
