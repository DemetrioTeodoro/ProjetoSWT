package model.seletor;

import model.entity.Categoria;

public class ProfissionalSeletor {
	private String nome;
	private Categoria categoria;
	private String cidade;
	private Integer qdeOS;

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (nome != null && nome.trim().length() > 0)

				|| (categoria != null) || (cidade != null) || (qdeOS != null);

		return temFiltroPreenchido;
	}
	
	public boolean temFiltroQdeZero() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (nome != null && nome.trim().length() > 0)

				|| (categoria != null) || (cidade != null);

		return temFiltroPreenchido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getQdeOS() {
		return qdeOS;
	}

	public void setQdeOS(Integer qdeOS) {
		this.qdeOS = qdeOS;
	}
	
	public void setQdeOS(String qdeOS) {
		try{
			this.qdeOS = Integer.parseInt(qdeOS) ;
		} catch (Exception e){
            this.qdeOS = null;
            System.out.println("Erro parseint na qdeOS ");
        }
	}

}
