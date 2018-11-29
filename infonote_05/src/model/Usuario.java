package model;

public class Usuario {
	
	private int matricula;
	private String login;
	private String senha;
	private String nome;
	private String email;
	private String telefone;
	
	private Endereco enderecos[] = new Endereco[10];
	private Pedido pedidos[] = new Pedido[10];
	
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
	public Endereco[] getEnderecos() {
		return enderecos;
	}
	public Pedido[] getPedidos() {
		return pedidos;
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
	// Inserir o pedido no vetor
	public boolean inserirPedido(Pedido pedido) {
		for (int i = 0; i < pedido.length; i++) {
			if (pedidos[i] == null) {
				pedidos[i] = pedido;
				return true;
			}
		}
		return false;
	}
	
	// Inserir o endereco no vetor
		public boolean inserirEndereco (Endereco end) {
			for (int i = 0; i < enderecos.length; i++) {
				if (enderecos[i] == null) {
					enderecos[i] = end;
					return true;
				}
			}
			return false;
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
	
	

