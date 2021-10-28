package cadastroEscola;

public class Usuario {
	
	private static String nome;
	private static String senha;
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public String getnome(){
		return this.nome;
	}
	public String getsenha(){
		return this.senha;
	}

	public static String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}