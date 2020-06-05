package model.entity;

public class Categoria {

	private String nome;

	public Categoria() {
		super();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria: " + nome;
	}

}
