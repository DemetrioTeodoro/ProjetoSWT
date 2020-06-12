package model.BO;

import model.DAO.ClienteDAO;
import model.entity.Cliente;

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

}
