package model;

public class ItemDePedido {
	
	public int qtde;
	public double subtotal;
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
	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
	}
	public void mostrar() {
		System.out.println("ITEM DE PEDIDO.");
		System.out.println("Quantidade: " + qtde);
		System.out.println("SubTotal: " + subtotal);
	}
	

}
