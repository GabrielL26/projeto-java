package model;

import java.text.NumberFormat;
import java.util.Locale;

public class ItemDePedido {
	
	private int qtde;
	private double subtotal;

	private Notebook notebook;
	
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Notebook getNotebook() {
		return notebook;
	}
	
	public ItemDePedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Ajuda a construir e a setar os valores do OBJETO.
	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
		
	}
	public ItemDePedido(int qtde, double subtotal,Notebook notebook) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
		this.notebook = notebook;
	}
	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		
		Locale local = new Locale("pt", "BR");
		
		retValue = "Informacoes sobre o Item de Pedido: " + ENTER + 
		"Quantidade: " + qtde + ENTER + 
		"Subtotal: " + 
				NumberFormat.getCurrencyInstance(local).format(this.subtotal) +
				ENTER + 
		"Notebook: " + notebook + ENTER;
		
		return retValue;
	}

}
