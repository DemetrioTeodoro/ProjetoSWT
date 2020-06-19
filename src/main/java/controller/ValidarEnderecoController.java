package controller;

public class ValidarEnderecoController {
	
	public String validarEndereco(String cep, String rua, String numero, String bairro, String cidade, String estado) {
		
		String msg = "";
		
		
		if (cep == null || cep.trim().isEmpty() || cep.trim().replace("-", "").isEmpty()) {
			msg += " Digite o CEP. \n";
		}
		if (rua == null || rua.trim().isEmpty()) {
			msg += " Digite a rua. \n";
		}
		if (numero == null || numero.trim().isEmpty()) {
			msg += " Digite o número de endereço. \n";
		}
		if (bairro == null || bairro.trim().isEmpty()) {
			msg += " Digite o bairro. \n";
		}
		if (cidade == null || cidade.trim().isEmpty()) {
			msg += " Digite a cidade. \n";
		}
		if (estado == null || estado.trim().isEmpty()) {
			msg += " Digite o estado ";
		}
		
		return msg;
	}

}
