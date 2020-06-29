package model.BO;

import java.util.ArrayList;

import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.seletor.ClienteSeletor;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();

	public String salvar(Cliente cliente) {

		String msg = "";

		Cliente c = new Cliente();

		if (dao.inscricaoJaUtilizada(cliente.getInscricao())) {

			msg = "Inscrição: " + cliente.getInscricao() + " já utilizada.";

		} else {
			c = dao.salvar(cliente);

			if (c.getId() > 0) {
				msg = "Cadastrado com sucesso";
			} else {
				msg = "Erro ao cadastrar";
			}
		}
		return msg;
	}

	public ArrayList<Cliente> listarClientes() {
		return dao.listarTodos();
	}

	public Endereco consultarEnderecoCliente(Cliente clienteSelecionado) {
		// TODO Auto-generated method stub
		return dao.consultarEndereco(clienteSelecionado);
	}

	public ArrayList<Cliente> listarClientes(ClienteSeletor seletor) {

		return dao.listarPorSeletor(seletor);
	}

	public String atualizar(Cliente cliente) {
		boolean atualizado = false;
		String msg = "";
		atualizado = dao.atualizar(cliente);
		if (atualizado == true) {
			return msg = " Cliente atualizado com sucesso. ";
		} else {
			return msg = " Ocorreu um erro ao atualizar cliente. ";
		}
	}

	public String excluir(Cliente cliente) {
		String msg = "";
		boolean excluiu = dao.excluir(cliente.getId());
		if (excluiu) {
			msg += " Excluido com sucesso! ";
		}else {
			msg += " Este cliente não pode ser excluido pois está viculado a uma Ordem de Serviço!. ";
		}
		return msg;
	}

}
