package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setMatricula(647411);
		usuario.setLogin("GabrielL26");
		usuario.setSenha("********");
		usuario.setNome("Gabriel");
		usuario.setEmail("gabriel@gmail.com");
		usuario.setTelefone("4002-8922");
		
		System.out.println("Matrícula: " + usuario.getMatricula());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Telefone: " + usuario.getTelefone());
		System.out.println("===================================================");
		
		
		Endereco endereco = new Endereco("Estádio Mario Filho Maracanã", "1", "0", "Maracanã", "Rio de Janeiro", "Rio de Janeiro", "21014-012");
		endereco.mostrar();
	    System.out.println("===================================================");
	    
	    
	    Pedido pedido = new Pedido(1, "22/11/2018", "Dinheiro", 2000, "Aprovado");
	    pedido.mostrar();
	    System.out.println("===================================================");
	    
	    
	    ItemDePedido Idp1 = new ItemDePedido(2, 22.98);
	    Idp1.mostrar();
	    System.out.println("===================================================");
	    
	    ItemDePedido Idp2 = new ItemDePedido(21, 98.75);
	    Idp2.mostrar();
	    System.out.println("===================================================");
	    
	    
	    Notebook note1 = new Notebook(21354, "Asus", "Intel Core i9, 8GB Ram, 1TB HD", 1500, 6899.90, "Nenhuma", "20/11/2018");
	    note1.mostrar();
	    System.out.println("===================================================");
	    
	    Notebook note2 = new Notebook(32564, "Dell", "Intel Core i9, 8GB Ram, 2TB HD", 1200, 7499.90, "Nenhuma", "20/11/2018");
	    note2.mostrar();
	    System.out.println("===================================================");
	    
	    Notebook note3 = new Notebook(56465, "Samsung", "Intel Core i7, 4GB Ram, 2TB HD", 900, 3599.90, "Nenhuma", "20/11/2018");
	    note3.mostrar();
	    System.out.println("===================================================");
	}
}
