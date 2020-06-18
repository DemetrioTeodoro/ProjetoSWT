package model.seletor;

public class ClienteSeletor {
	private String nome;
	private String inscricao;

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (nome != null && nome.trim().length() > 0)

							|| (inscricao != null && inscricao.trim().length() > 0);

		return temFiltroPreenchido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}
	
}
