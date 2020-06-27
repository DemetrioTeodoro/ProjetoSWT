package model.seletor;

import java.time.LocalDate;

import model.entity.Profissional;

public class AgendaSeletor {
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private Profissional profissional;

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (dataInicio != null) || (dataTermino != null)
				|| (profissional != null);

		return temFiltroPreenchido;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
}
