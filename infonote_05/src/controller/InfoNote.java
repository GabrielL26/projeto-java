package controller;

import model.Usuario;
import util.Teclado;

public class InfoNote {
	
	Usuario user;
	boolean logado = false;
	
		public void mostrarMenu() {
			System.out.println("=================================================");
			System.out.println("      InfoNote - Se não é Info não vendemos.     ");
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
				if (login.equals("admin") && senha.equals("1234")) {
					System.out.println("Login efetuado com sucesso.");
					logado = true;
				}else {
					System.out.println("Login ou Senha inválido.");
					efetuarLogin();
				}
		}
		
		public void cadastrarUsuario() {
			System.out.println("=================================================");
			System.out.println("      InfoNote - Cadastro de Usuários.           ");
			System.out.println("=================================================");
			System.out.println("Matrícula: ");
			System.out.println("Login: ");
			System.out.println("Senha: ");
			System.out.println("Nome: ");
			System.out.println("E-mail: ");
			System.out.println("Telefone: ");
			
			user = new Usuario(32155, "gabriell26", "1234", "Gabriel", "gabriel@gmail.com", "4002-8922");
			
			System.out.println("=================================================");
			System.out.println("      Usuário Cadastrado Com Sucesso.            ");
			System.out.println("=================================================");
			
			System.out.println(user);
		}
		
		public void buscarNotebook() {
			System.out.println("buscarNotebook - Em Construção");
		}
		
		public void manterCarrinho() {
			System.out.println("manterCarrinho - Em Construção");
		}
		
		public void efetuarCompra() {
			System.out.println("efetuarCompra - Em Construção");
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
				info.cadastrarUsuario();
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
		
	}



