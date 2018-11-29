package model;

public class Usuario {
	
	private int matricula;
	private String login;
	private String senha;
	private String nome;
	private String email;
	private String telefone;
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(int matricula, String login, String senha, String nome, String email, String telefone) {
		super();
		this.matricula = matricula;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	//Mostrar para ser chamado no TESTE e da a saída.
			public void mostrar() {
				System.out.println("USUARIO.");
				System.out.println("Matricula: " + matricula);
				System.out.println("Login: " + login);
				System.out.println("Senha: " + senha);
				System.out.println("Nome: " + nome);
				System.out.println("E-mail: " + email);
				System.out.println("Telefone: " + telefone);
		
			}
	
	}
	
	

