package model.entity;

public class Cliente extends Pessoa{
	
	private boolean ehCpf;
	
	public Cliente() {
		super();
	}
	
	public Cliente( boolean ehCpf) {
		super();
		this.ehCpf = ehCpf;
	}
	
	public boolean isEhCpf() {
		return ehCpf;
	}
	public void setEhCpf(boolean ehCpf) {
		this.ehCpf = ehCpf;
	}
	
	@Override
	public String toString() {
		return getNome() + " - "+ getInscricao() + getEndereco();
	}

}
