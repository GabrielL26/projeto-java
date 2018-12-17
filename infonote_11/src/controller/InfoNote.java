package controller;

import model.ItemDePedido;
import model.Notebook;
import model.Pedido;


import java.text.DateFormat;
import java.util.Date;

import model.Cliente;
import model.Endereco;
import model.Funcionario;
import util.GerarSenha;
import util.Teclado;


public class InfoNote {
	
	Cliente cliente;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	
	private static Cliente clienteGlobal = null;
	private static Funcionario funcionarioGlobal =null;
	
	boolean logado = false;
	
		public InfoNote() {
			notebooks[0] = new Notebook(1, "Negativo N22BR", "CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB",
					6, 1200.00, "img\\\\n22br.jpg","19/05/2011");
			
			notebooks[1] = new Notebook(2, "Bell B55BR", "CPU Intel I3, Memória 4 GB, HD 500 GB",
					3, 1800.00, "img\\b55br.jpg", "20/05/2011");
			
			notebooks[2] = new Notebook(3, "Pompaq P41BR", "CPU Intel I3, Memória 3 GB, HD 320 GB",
					1, 1600.00, "img\\p41br.jpg", "21/05/2011");
			
			notebooks[3] = new Notebook(4, "CCF CR71CH","CPU Intel Dual Core, Memória 2 GB, HD 160 GB",
					5, 1100.00, "img\\cr71ch.jpg", "10/06/2011");
			
			notebooks[4] = new Notebook(5, "BradescoTech BD22BR", "CPU AMD Phenon II, Memória 4 GB, HD 500 GB",
					2, 1900.00, "img\\bd22br.jpg","10/06/2011");		
		}
		
		public static void main(String[] args) {
			InfoNote info = new InfoNote();
			
			int opcao = 8;
			do {
				info.mostrarMenu();
				opcao = Teclado.lerInt("Digite sua Opção: ");
				
				switch (opcao) {
				
				case 1:
					info.efetuarLogin();
					break;
					
				case 2:
					info.cadastrarCliente();
					break;
					
				case 3:
					info.buscarNotebook();
					break;
					
				case 4:
					info.manterCarrinho();
					break;
					
				case 5:
					info.manterCarrinho();
					break;
					
				case 6:
					info.manterCarrinho();
					break;
					
				case 7:
					if (!info.logado) {
						System.out.println("Efetue login para efetuar compra.");
						break;
					} else {
						info.efetuarCompra();
						break;
					}
					
				case 8:
					System.out.println("Saída do Sistema.");
					break;
					
				default:
					System.out.println("Opção inválida!");
				}
			}while(opcao!=8);
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		}
	
		public void mostrarMenu() {
			System.out.println("=================================================");
			System.out.println("      InfoNote - Se não é Info não vendemos.     " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
					+ " " + DateFormat.getTimeInstance().format(new Date()));
			
			if (logado == true) {
				System.out.println("Seja bem vindo, " + clienteGlobal.getNomeInvertido());
			}
			System.out.println("=================================================");
			System.out.println("1 - Login");
			System.out.println("2 - Cadastrar Cliente");
			System.out.println("3 - Buscar Notebook");
			System.out.println("4 - Inserir Notebook no carrinho");
			System.out.println("5 - Remover Notebook no carrinho");
			System.out.println("6 - Ver Carrinho");
			System.out.println("7 - Efetuar Compra");
			System.out.println("8 - Sair");
		}
		
		public void efetuarLogin() {
			String login,  senha;
			login = Teclado.lerTexto("Digite o login: ");
			senha = Teclado.lerTexto("Digite a senha: ");
				if (clienteGlobal != null) {
					logado = clienteGlobal.validarLogin(login, senha);
					if (logado) {
						System.out.println("Login efetuado com sucesso!");
					} else {
						System.out.println("Ususario ou senha inválido.");
					}
				}
				else 
				{
					logado = funcionarioGlobal.validarLogin(login, senha);
					if (logado) {
						System.out.println("Login efetuado com sucesso!");
					} else {
						System.out.println("Ususario ou senha inválido.");
					}
				}
		}
		
		public void cadastrarCliente() {
			System.out.println("=================================================");
			System.out.println("      InfoNote - Cadastro de Usuários.           ");
			System.out.println("=================================================");
			
			String login = Teclado.lerTexto("login: ");
			String senha = Teclado.lerTexto("Senha: ");
			if (senha.equals("") || senha == null) {
				senha = GerarSenha.gerarSenha();
				System.out.println("Senha gerada: " + senha);
			}
			int tipo = 1;
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
			

			
			Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
			
			Cliente cliente = new Cliente(login, senha, tipo, codigoCliente, nome, email, telefone, endereco);
			clienteGlobal = cliente ;
			
			System.out.println("=================================================");
			System.out.println("      Usuário Cadastrado Com Sucesso.            ");
			System.out.println("=================================================");
			System.out.println(cliente);
			System.out.println(endereco);
		}
		
		public void buscarNotebook() {
			for (int i = 0; i < notebooks.length; i++) {
				if(notebooks[i] != null) {
					System.out.println(notebooks[i].getserialNote()+"-----"+
								notebooks[i].getModelo());
				}
			}
		}

		public void manterCarrinho() {
			System.out.println("manterCarrinho - Em Construção");
		}
		
		@SuppressWarnings("unlikely-arg-type")
		public void inserirNotebook() {
			//Lê o notebook escolhido do teclado
			String numeroNote = Teclado.lerTexto("Informe o número do notebook" + 
					" para compra: ");
			//Cria pedido
			if (pedido == null) {
				pedido = new Pedido();
			}
			//Busca notebook selecionado
			Notebook aux = null;
			for (int i = 0; i < notebooks.length; i++) {
				if (notebooks[i] != null && 
							numeroNote.equals(notebooks[i].getserialNote())) {
						aux = notebooks[i];
				}
			}
			// Se não existir, interrompe
			if (aux == null) {
				return;
			}
			
			// Cria item
			ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);
			
			//Inserir item no pedido
			pedido.inserirItem(item);
		}
		
		public void efetuarCompra() {
			System.out.println("efetuarCompra - Em Construção");
		}
	}



