package model;

public class ItemDePedido {
	
	private int qtde;
	private double subtotal;
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
	
	//Ajuda a construir e a setar os valores do OBJETO.
	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
	}
	public ItemDePedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Mostrar para ser chamado no TESTE e da a sa�da.
	public void mostrar() {
		System.out.println("ITEM DE PEDIDO.");
		System.out.println("Quantidade: " + qtde);
		System.out.println("SubTotal: " + subtotal);
	}
	

}
