package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.BO.BuscarCep;
import model.BO.OrdemServicoBO;
import model.details.CadastroOS;
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

	public String cadastrarOS(CadastroOS cadOS) {

			LocalDate dtTermino = null;
			LocalDate dtCadastro = LocalDate.now();

			if (cadOS.isFinalizada()) {
				dtTermino = LocalDate.now();
			}

			OrdemServico os = new OrdemServico();
			os.setCategorias(cadOS.getCategorias());
			os.setProfissionais(cadOS.getProfissionais());
			os.setCliente(cadOS.getCliente());
			os.setDataInicio(cadOS.getDataInicio());
			os.setDataPrevistaFim(cadOS.getDataPrevistaFim());
			os.setDataTermino(dtTermino);
			os.setDescricao(cadOS.getDescricao());
			os.setEndereco(cadOS.getEndereco());
			os.setNumeroOS(cadOS.getNumeroOS());
			os.setDataCadastro(dtCadastro);

			System.out.println(os);
			msg = ordemServicoBO.cadastrarOS(os);

		return msg;
	}

	public String validarCampos(CadastroOS cadOS) {

		if (cadOS.getNumeroOS() == null || cadOS.getNumeroOS().trim().isEmpty()) {
			msg += " Digite o numero da Ordem de Serviço. \\n";
		}
		if (cadOS.getCliente() == null) {
			msg += " Selecione um cliente. \n";
		}
		if (cadOS.getCategorias() == null || cadOS.getCategorias().size() == 0) {
			msg += " Selecione uma categoria. \n";
		}
		if (cadOS.getProfissionais() == null || cadOS.getProfissionais().size() == 0) {
			msg += " Selecione um profissional. \n";
		}
		if (cadOS.getDescricao() == null || cadOS.getDescricao().trim().isEmpty()) {
			msg += " Digite a descrição. \n";
		}
		if (cadOS.getDataPrevistaFim() == null) {
			msg += " Digite a data prevista para término. \n";
		}
		if (cadOS.getDataInicio() == null) {
			msg += " Digite a data de início. \n";
		}
		if (cadOS.getDataInicio() != null && cadOS.getDataPrevistaFim() != null) {
			if (cadOS.getDataInicio().isAfter(cadOS.getDataPrevistaFim())) {
				msg += " A data de início deve ser menor que a data prevista para término. \n";
			}
		}
		
		ValidarEnderecoController validarEndereco = new ValidarEnderecoController();
		msg += validarEndereco.validarEndereco(cadOS.getEndereco().getCep(), cadOS.getEndereco().getRua(),
				cadOS.getEndereco().getNumero(), cadOS.getEndereco().getBairro(), cadOS.getEndereco().getCidade(),
				cadOS.getEndereco().getEstado());

		return msg;
	}

}
