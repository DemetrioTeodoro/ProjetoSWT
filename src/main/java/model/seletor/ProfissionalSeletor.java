package model.seletor;

import java.time.LocalDate;
import model.entity.Categoria;

public class ProfissionalSeletor {
	private String nome;
	private Categoria categoria;
	private String cidade;
	private LocalDate dataInicio;
	private LocalDate dataPrevTermino;
	private Integer qdeOS;

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (nome != null && nome.trim().length() > 0)

				|| (categoria != null) || (cidade != null) || (dataInicio != null)
				|| (dataPrevTermino != null)|| (qdeOS != null);

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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataPrevTermino() {
		return dataPrevTermino;
	}

	public void setDataPrevTermino(LocalDate dataPrevTermino) {
		this.dataPrevTermino = dataPrevTermino;
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
