package model.BO;

import java.util.ArrayList;

import model.DAO.ClienteDAO;
import model.entity.Cliente;
import model.entity.Endereco;

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

}
