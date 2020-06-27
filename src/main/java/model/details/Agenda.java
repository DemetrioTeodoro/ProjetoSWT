package model.details;

import java.time.LocalDate;

public class Agenda {
	private int idOrdemServico;
	private LocalDate inicio;
	private LocalDate fim;
	private String bairro;
	private String cidade;
	private String estado;
	private String numOS;
	private String cliente;
	private String telCliente;
	public int getIdOrdemServico() {
		return idOrdemServico;
	}
	public void setIdOrdemServico(int idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumOS() {
		return numOS;
	}
	public void setNumOS(String numOS) {
		this.numOS = numOS;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getTelCliente() {
		return telCliente;
	}
	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}

	public String TextoEndereco() {
		return  bairro + ", " + cidade + "/" + estado ;
	}

	public String TextoCliente() {
		return cliente + " (" + telCliente + ")";
	}
	
	
	
	

	

}
