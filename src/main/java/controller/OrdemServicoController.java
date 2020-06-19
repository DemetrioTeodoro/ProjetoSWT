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
import model.seletor.OrdemServicoSeletor;

public class OrdemServicoController {

	
	private OrdemServicoBO ordemServicoBO = new OrdemServicoBO();

	public Endereco buscarEnderecoPorCep(String cep) {
		BuscarCep buscarCep = new BuscarCep();
		return buscarCep.buscarCep(cep);
	}

	public String cadastrarOS(CadastroOS cadOS) {
		String msg="";

			LocalDate dtTermino = null;
			LocalDate dtCadastro = LocalDate.now();

			if (cadOS.isFinalizada()) {
				dtTermino = LocalDate.now();
			}else {
				dtTermino = null;
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
		String msg = "";

		if (cadOS.getNumeroOS() == null || cadOS.getNumeroOS().trim().isEmpty()) {
			msg += " Digite o numero da Ordem de Serviço. \n";
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

	public ArrayList<OrdemServico> listarClientes(OrdemServicoSeletor seletor) {
		return ordemServicoBO.listarClientes(seletor);
	}

}
