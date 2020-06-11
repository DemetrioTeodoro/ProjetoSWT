package model.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdemServico {
	private int id;
	private String numeroOS;
	private Cliente cliente;
	private Endereco endereco;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataPrevistaFim;
	private LocalDate dataTermino;
	private ArrayList<Categoria>categorias;
	private ArrayList<Profissional> profissionais;
		
	public OrdemServico(String numeroOS, Cliente cliente, Endereco endereco, String descricao, LocalDate dataInicio,
			LocalDate dataPrevistaFim, LocalDate dataTermino, ArrayList<Categoria> categorias,
			ArrayList<Profissional> profissionais) {
		super();
		this.numeroOS = numeroOS;
		this.cliente = cliente;
		this.endereco = endereco;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataPrevistaFim = dataPrevistaFim;
		this.dataTermino = dataTermino;
		this.categorias = categorias;
		this.profissionais = profissionais;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataPrevistaFim() {
		return dataPrevistaFim;
	}
	public void setDataPrevistaFim(LocalDate dataPrevistaFim) {
		this.dataPrevistaFim = dataPrevistaFim;
	}
	
	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	public ArrayList<Profissional> getProfissionais() {
		return profissionais;
	}
	public void setProfissionais(ArrayList<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	@Override
	public String toString() {
		return "OrdemServico [numeroOS=" + numeroOS + ", cliente=" + cliente + ", endereco=" + endereco + ", descricao="
				+ descricao + ", dataInicio=" + dataInicio + ", dataPrevistaFim=" + dataPrevistaFim
				+  ", categorias=" + categorias + ", profissionais="
				+ profissionais + "]";
	}
	

}
