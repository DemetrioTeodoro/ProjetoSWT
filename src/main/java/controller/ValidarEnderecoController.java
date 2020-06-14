package controller;

public class ValidarEnderecoController {
	
	public String validarEndereco(String cep, String rua, String numero, String bairro, String cidade, String estado) {
		
		String msg = "";
		
		if (cep == null || cep.isEmpty()) {
			msg += " Digite o cep. \n";
		}
		if (rua == null || rua.isEmpty()) {
			msg += " Digite a rua. \n";
		}
		if (numero == null || numero.isEmpty()) {
			msg += " Digite o número. \n";
		}
		if (bairro == null || bairro.isEmpty()) {
			msg += " Digite o bairro. \n";
		}
		if (cidade == null || cidade.isEmpty()) {
			msg += " Digite a cidade. \n";
		}
		if (estado == null || estado.isEmpty()) {
			msg += " Digite o estado ";
		}
		
		return msg;
	}

}
