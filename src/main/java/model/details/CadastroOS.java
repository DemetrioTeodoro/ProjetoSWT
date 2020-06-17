package model.details;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.Cliente;
import model.entity.Endereco;
import  model.entity.Categoria;
import  model.entity.Profissional;

public class CadastroOS {
	private String numeroOS;
	private Cliente cliente;
	private Endereco endereco;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataPrevistaFim;
	private boolean finalizada;
	private ArrayList<Categoria> categorias;
	private ArrayList<Profissional> profissionais;
	
	
	public CadastroOS(String numeroOS, Cliente cliente, Endereco endereco, String descricao, 
			LocalDate dataInicio, LocalDate dataPrevistaFim, boolean finalizada, ArrayList<Categoria> categorias,
			ArrayList<Profissional> profissionais) {
		super();
		this.numeroOS = numeroOS;
		this.cliente = cliente;
		this.endereco = endereco;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataPrevistaFim = dataPrevistaFim;
		this.categorias = categorias;
		this.profissionais = profissionais;
		this.finalizada = finalizada;
	}
	public CadastroOS() {
		super();
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
	
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	

}
