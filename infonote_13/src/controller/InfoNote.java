package controller;

import model.ItemDePedido;
import model.Notebook;
import model.Pedido;
import model.Usuario;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.NotebookDAO;
import model.DAO.UsuarioDAO;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import model.Cliente;
import model.Endereco;
import model.Funcionario;
import util.Ajuda;
import util.Configurador;
import util.GerarSenha;
import util.Teclado;

public class InfoNote {

	Cliente cliente; // n�o esquecer de dar o import neste objeto.
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	private static Cliente clienteGlobal = null;
	private static final int AREA_ADMINISTRATIVA = 9;
	private static final int SAIR = 10;
	boolean logado = false; // indica se o usu�rio est� logado.
	Usuario usuario;

	Configurador config;
	Ajuda ajuda;

	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;

	public InfoNote() {
		notebooks[0] = new Notebook("1", "Negativo N22BR", "CPU Intel Core 2 Duo, Mem�ria 2 GB, HD 250 GB", 6, 1200.00,
				"img\\\\n22br.jpg", "19/05/2011");

		notebooks[1] = new Notebook("2", "Bell B55BR", "CPU Intel I3, Mem�ria 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");

		notebooks[2] = new Notebook("3", "Pompaq P41BR", "CPU Intel I3, Mem�ria 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");

		notebooks[3] = new Notebook("4", "CCF CR71CH", "CPU Intel Dual Core, Mem�ria 2 GB, HD 160 GB", 5, 1100.00,
				"img\\cr71ch.jpg", "10/06/2011");

		notebooks[4] = new Notebook("5", "BradescoTech BD22BR", "CPU AMD Phenon II, Mem�ria 4 GB, HD 500 GB", 2, 1900.00,
				"img\\bd22br.jpg", "10/06/2011");
		

		// Cria objeto de configura��es
		config = new Configurador();
		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
		// Cria o objeto Ajuda
		ajuda = new Ajuda(config.getArquivoAjuda());
	}

	public static void main(String[] args) {
		InfoNote info = new InfoNote();

		int opcao = SAIR;
		do {
			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua Op��o: ");

			switch (opcao) {

			case LOGIN:
				info.efetuarLogin();
				break;

			case CADASTRAR_USUARIO:
				info.cadastrarCliente();
				break;

			case BUSCAR_NOTEBOOK:
				//info.buscarNotebook();
				info.mostrarMenu();
				break;

			case INSERIR_NOTEBOOK:
				info.manterCarrinho();
				break;

			case REMOVER_NOTEBOOK:
				info.manterCarrinho();
				break;

			case VER_CARRINHO:
				info.manterCarrinho();
				break;

			case EFETUAR_COMPRA:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;
				} else {
					info.efetuarCompra();
					break;
				}

			case AJUDA:
				info.ajuda();
				break;

			case AREA_ADMINISTRATIVA:
				info.areaAdministrativa();
				break;

			case SAIR:
				System.out.println("Sa�da do Sistema.");
				break;

			default:
				System.out.println("Op��o inv�lida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != SAIR);
	}

	public void mostrarMenu() {
		System.out.println("=================================================");
		System.out.println("      InfoNote - Se n�o � Info n�o vendemos.     "
				+ DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));

		if (logado == true) {
			System.out.println("Seja bem vindo, " + cliente.getNomeInvertido());
		}
		System.out.println("=================================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar Notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - Ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Ajuda");
		System.out.println("9 - �rea Administrativa");
		System.out.println("10 - Sair");
	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");

		cliente = ClienteDAO.buscarPorLoginSenha(login, senha);

		if (cliente != null) {
			logado = cliente.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Ususario ou senha inv�lido.");
			}

			int opcao2 = 3;
			do {
				System.out.println("Digite:");
				System.out.println("1 - Para efetuar Login");
				System.out.println("2 - Para cadastrar-se");
				System.out.println("3 - Para sair do sistema");
				opcao2 = Teclado.lerInt("");
				switch (opcao2) {
				case 1:
					efetuarLogin();
					break;
				case 2:
					cadastrarCliente();
					break;
				case 3:
					System.out.println("Obrigado e volte sempre!");
					break;
				default:
					System.out.println("Op��o inv�lida");
				}
			} while (!logado);
		}
	}

	
	public void cadastrarCliente() {
		System.out.println("=================================================");
		System.out.println("      InfoNote - Cadastro de Usu�rios.           ");
		System.out.println("=================================================");
		
		String login = Teclado.lerTexto("login: ");
		String senha = Teclado.lerTexto("Senha: ");
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}
		int tipo = 0; // por que todo cliente � tipo zero
		String codigoCliente = Teclado.lerTexto("Codigo Cliente: ");
		String nome = Teclado.lerTexto("Nome: ");
		String email = Teclado.lerTexto("Email: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		
		String logradouro = Teclado.lerTexto("Logradouro: ");
		String numero = Teclado.lerTexto("Numero: ");
		String complemento = Teclado.lerTexto("Complemento: ");
		String bairro = Teclado.lerTexto("Bairro: ");
		String cidade = Teclado.lerTexto("Cidade: ");
		String estado = Teclado.lerTexto("Estado: ");
		String cep = Teclado.lerTexto("CEP: ");
		
		usuario = UsuarioDAO.inserir(login, senha, tipo);
		
		cliente = ClienteDAO.inserir(login, senha, tipo, codigoCliente, nome, email, telefone);
		
		Endereco endereco = EnderecoDAO.inserir(logradouro, numero, complemento, bairro, cidade, estado, cep,
				codigoCliente);
		
		// Aqui acima o tipo recebeu valor zero, para no futuro,
		// ocorrer uma associa��o zero para cliente e um para administrador.
		
		System.out.println("=================================================");
		System.out.println("      Usu�rio Cadastrado Com Sucesso.            ");
		System.out.println("=================================================");
		System.out.println(cliente);
		System.out.println(endereco);
	}

	public void efetuarLoginAdm() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");
		Funcionario funcionario = FuncionarioDAO.buscarPorLoginSenha(login, senha);
		if (funcionario != null) {
			logado = funcionario.validarLogin(login, senha);
		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usu�rio ou senha inv�lido.");
				System.exit(0);
			}
		}
	}
	
	public void areaAdministrativa() {
		InfoNote info = new InfoNote();
		efetuarLoginAdm();
		System.out.println("Op��es Administrativas\n");
		System.out.println("1 - Cadastrar Notebook");
		System.out.println("2 - Mostrar Notebooks");
		System.out.println("3 - Editar Notebook");
		System.out.println("4 - Excluir Notebook");
		System.out.println("5 - Sair");
		int opcao = 5;
		do {
			opcao = Teclado.lerInt("Digite sua op��o: ");
			switch (opcao) {
			case 1:
				info.cadastrarNotebook();
				break;
			case 2:
				info.mostrarNotebooks();
				break;
			case 3:
				info.editarNotebook();
				break;
			case 4:
				info.excluirNotebook();
				break;
			case 5:
				System.out.println("Sa�da do Sistema");
				break;
			default:
				System.out.println("Op��o inv�lida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != 5);
	}


	
	public void cadastrarNotebook() {
		System.out.println("=================================");
		System.out.println("        Cadastrar Notebook       ");
		System.out.println("=================================");
		
		String serialNote = Teclado.lerTexto("Numero do Notebook: ");
		String modelo = Teclado.lerTexto("Modelo: ");
		String descricao = Teclado.lerTexto("Descri��o: ");
		int estoque = Teclado.lerInt("estoque: ");
		double precoUnitario = Teclado.lerDouble("Pre�o Unitario: ");
		String figura = Teclado.lerTexto("Figura: ");
		String dataCadastro = Teclado.lerTexto("Data do Cadastro: ");

		Notebook notebook = NotebookDAO.inserir(serialNote, modelo, descricao, estoque, precoUnitario, figura, dataCadastro);

		System.out.println(notebook);
	}
	
	public void buscarNotebook() {
		
	}
	
	private void mostrarNotebooks() {
		Notebook[] notebooks = NotebookDAO.buscarTodos();

		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getserialNote() + "-----" + notebooks[i].getModelo() + "-----"
						+ notebooks[i].getDescricao() + "-----" + notebooks[i].getEstoque()+ "-----" + notebooks[i].getPrecoUnitario()
						+ "-----" + notebooks[i].getFigura()+ "-----" + notebooks[i].getDataCadastro());
			}
		}
			
	}
	
	public void editarNotebook() {
		System.out.println("=================================");
		System.out.println("         Editar Notebook         ");
		System.out.println("=================================");
		
		int id_notebook = Teclado.lerInt("Editar Id_notebook: ");
		String descricao = Teclado.lerTexto("Editar Descri��o: ");
		int estoque = Teclado.lerInt("Editar Estoque: ");
		double precoUnitario = Teclado.lerDouble("Editar Pre�o Unit�rio: ");
		String figura = Teclado.lerTexto("Editar Figura: ");
		String dataCadastro = Teclado.lerTexto("Editar Data de Cadastro: ");
		
		NotebookDAO.atualizar(id_notebook, descricao, estoque, precoUnitario, figura, dataCadastro);
		
		System.out.println("Notebook editado com sucesso");
		
	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Constru��o");
	}
	
	public void excluirNotebook() {
		System.out.println("=================================");
		System.out.println("        Excluir Notebook         ");
		System.out.println("=================================");
		
		String serialNote = Teclado.lerTexto("Excluir Id_notebook: ");
		
		NotebookDAO.excluir(serialNote);
		
		System.out.println("Notebook apagado com sucesso");
	}

	public void inserirNotebook() {
		// L� o notebook escolhido do teclado
		String numeroNote = Teclado.lerTexto("Informe o n�mero do notebook" + " para compra: ");
		// Cria pedido
		if (pedido == null) {
			pedido = new Pedido();
		}
		// Busca notebook selecionado
		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getserialNote())) {
				aux = notebooks[i];
			}
		}
		// Se n�o existir, interrompe
		if (aux == null) {
			return;
		}

		// Cria item
		ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);

		// Inserir item no pedido
		pedido.inserirItem(item);
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Constru��o");
	}

	public void ajuda() {
		System.out.println(ajuda.getTexto());
	}
}
