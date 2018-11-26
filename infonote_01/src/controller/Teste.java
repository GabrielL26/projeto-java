package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {
		
		//Objeto "Usuario" instanciado, com os atributos setados.
		Usuario usuario = new Usuario();
			usuario.setEmail("gabriel@gmail.com");
			usuario.setLogin("gabriell26");
			usuario.setMatricula(23156);
			usuario.setNome("Gabriel");
			usuario.setSenha("********");
			usuario.setTelefone("4002-8922");
			System.out.println(usuario.toString());
			 
				
					System.out.println("===================================================");
		
		
		//Objeto "Endereco" instanciado, com os atributos setados.
		Endereco endereco = new Endereco("Estádio Mario Filho Maracanã", "1", "0", "Maracanã", "Rio de Janeiro", "Rio de Janeiro", "21014-012");
			endereco.mostrar();
				System.out.println("===================================================");
	    
	    
	    //Objeto "Pedido" instanciado, com os atributos setados.
	    Pedido pedido = new Pedido(1, "22/11/2018", "Dinheiro", 2000, "Aprovado");
	    	pedido.mostrar();
	    		System.out.println("===================================================");
	     
	    
	    //Objeto "ItemDePedido1" instanciado, com os atributos setados.
	    ItemDePedido Idp1 = new ItemDePedido(2, 22.98);
	    	Idp1.mostrar();
	    		System.out.println("===================================================");
	    
	    //Objeto "ItemDePedido2" instanciado, com os atributos setados.
	    ItemDePedido Idp2 = new ItemDePedido(21, 98.75);
	    	Idp2.mostrar();
	    		System.out.println("===================================================");
	    
	    
	    //Objeto "Notebook1" instanciado, com os atributos setados.
	    Notebook note1 = new Notebook(21354, "Asus", "Intel Core i9, 8GB Ram, 1TB HD", 1500, 6899.90, "Nenhuma", "20/11/2018");
	    	note1.mostrar();
	    		System.out.println("===================================================");
	    
	    //Objeto "Notebook2" instanciado, com os atributos setados.
	    Notebook note2 = new Notebook(32564, "Dell", "Intel Core i9, 8GB Ram, 2TB HD", 1200, 7499.90, "Nenhuma", "20/11/2018");
	    	note2.mostrar();
	    		System.out.println("===================================================");
	    
	    //Objeto "Notebook3" instanciado, com os atributos setados.
	    Notebook note3 = new Notebook(56465, "Samsung", "Intel Core i7, 4GB Ram, 2TB HD", 900, 3599.90, "Nenhuma", "20/11/2018");
	    	note3.mostrar();
	    
	}
}
