package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {

		// Objeto "Usuario" instanciado, com os atributos setados.
		Usuario usuario = new Usuario();
			usuario.setEmail("gabriel@gmail.com");
			usuario.setLogin("gabriell26");
			usuario.setMatricula(23156);
			usuario.setNome("Gabriel");
			usuario.setSenha("********");
			usuario.setTelefone("4002-8922");
				System.out.println(usuario.toString());
		System.out.println("===================================================");

		// Objeto "Endereco" instanciado, com os atributos setados.
		Endereco endereco = new Endereco();
			endereco.setBairro("Maracanã");
			endereco.setCep("21014-012");
			endereco.setCidade("RJ");
			endereco.setComplemento("0");
			endereco.setEstado("RJ");
			endereco.setLogradouro("Estádio Mario Filho Maracanã");
			endereco.setNumero("0");
				System.out.println(endereco.toString());
		System.out.println("===================================================");

		// Objeto "Pedido" instanciado, com os atributos setados.
		Pedido pedido = new Pedido();
			pedido.setNumero(1);
			pedido.setDataEmissao("22/11/2018");
			pedido.setFormaDePagamento("Dinheiro");
			pedido.setValorTotal(2000);
			pedido.setSituacao("Aprovado");
				System.out.println(pedido.toString());
		System.out.println("===================================================");

		// Objeto "ItemDePedido1" instanciado, com os atributos setados.
		ItemDePedido Idp1 = new ItemDePedido();
			Idp1.setQtde(2);
			Idp1.setSubtotal(22.98);
				System.out.println(Idp1.toString());
		System.out.println("===================================================");

		// Objeto "ItemDePedido2" instanciado, com os atributos setados.
		ItemDePedido Idp2 = new ItemDePedido();
			Idp2.setQtde(21);
			Idp2.setSubtotal(98.75);
				System.out.println(Idp2.toString());
		System.out.println("===================================================");

		// Objeto "Notebook1" instanciado, com os atributos setados.
		Notebook note1 = new Notebook();
			note1.setDataCadastro("20/11/2018");
			note1.setDescricao("Intel Core i9");
			note1.setEstoque(1500);
			note1.setFigura("Nenhuma");
			note1.setModelo("Asus");
			note1.setNumeroNote(21354);
			note1.setPrecoUnitario(6899.99);
				System.out.println(note1.toString());
		System.out.println("===================================================");

		// Objeto "Notebook2" instanciado, com os atributos setados.
		Notebook note2 = new Notebook();
			note2.setDataCadastro("20/11/2018");
			note2.setDescricao("Intel Core i7");
			note2.setEstoque(850);
			note2.setFigura("Nenhuma");
			note2.setModelo("Dell");
			note2.setNumeroNote(32564);
			note2.setPrecoUnitario(5205.99);
				System.out.println(note2.toString());
		System.out.println("===================================================");

		// Objeto "Notebook3" instanciado, com os atributos setados.
		Notebook note3 = new Notebook();
			note3.setDataCadastro("20/11/2018");
			note3.setDescricao("Intel Core i5");
			note3.setEstoque(500);
			note3.setFigura("Nenhuma");
			note3.setModelo("Acer");
			note3.setNumeroNote(56465);
			note3.setPrecoUnitario(2789.99);
				System.out.println(note3.toString());

	}
}
