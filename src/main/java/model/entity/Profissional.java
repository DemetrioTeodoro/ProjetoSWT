package model.entity;

import java.util.ArrayList;

public class Profissional extends Pessoa{
	
	
	private ArrayList<Categoria> categorias;
	
	public Profissional() {
		super();
		
	}
	public Profissional( ArrayList<Categoria> categorias) {
		super();
		
		this.categorias = categorias;
	}
	
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	@Override
	public String toString() {
		return getNome() + "-" +getInscricao() ;
	}
	
	
	

}
