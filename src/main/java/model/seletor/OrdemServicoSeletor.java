package model.seletor;

import model.entity.Categoria;
import model.entity.Cliente;

public class OrdemServicoSeletor {

	private String numeroOS;
	private Cliente cliente;
	private Categoria catgoria;

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (numeroOS != null || !numeroOS.trim().isEmpty()) || (cliente != null)
				|| (catgoria != null);

		return temFiltroPreenchido;
	}

	public String getNumeroOS() {
		return numeroOS;
	}

	public void setNumeroOS(String numeroOS) {
		this.numeroOS = numeroOS;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Categoria getCatgoria() {
		return catgoria;
	}

	public void setCatgoria(Categoria catgoria) {
		this.catgoria = catgoria;
	}

	@Override
	public String toString() {
		return "OrdemServicoSeletor [numeroOS=" + numeroOS + ", cliente=" + cliente + ", catgoria=" + catgoria + "]";
	}

}
