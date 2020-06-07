package model.entity;

public class Cliente extends Pessoa{
	
	private Pessoa pessoa;
	private boolean ehCpf;
	
	
	public Cliente() {
		super();
		
	}
	public Cliente(Pessoa pessoa, boolean ehCpf) {
		super();
		this.pessoa = pessoa;
		this.ehCpf = ehCpf;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public boolean isEhCpf() {
		return ehCpf;
	}
	public void setEhCpf(boolean ehCpf) {
		this.ehCpf = ehCpf;
	}
	
	@Override
	public String toString() {
		return pessoa.getNome() + " - "+pessoa.getInscricao();
	}

}
