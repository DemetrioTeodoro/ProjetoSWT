package model.entity;

import java.util.ArrayList;

public class Profissional extends Pessoa{
	
	private Pessoa pessoa;
	private ArrayList<Categoria> categorias;
	
	public Profissional() {
		super();
		
	}
	public Profissional(Pessoa pessoa, ArrayList<Categoria> categorias) {
		super();
		this.pessoa = pessoa;
		this.categorias = categorias;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	@Override
	public String toString() {
		return pessoa.getNome() + "-" +pessoa.getInscricao() ;
	}
	
	
	

}
