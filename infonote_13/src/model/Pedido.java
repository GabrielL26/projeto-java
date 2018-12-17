package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Pedido {

	private int numeroPedido;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;
	private Endereco enderecoEntrega;
	private ItemDePedido itens[] = new ItemDePedido[10];
	public int length;
	
	public int getNumero() {
		return numeroPedido;
	}
	public void setNumero(int numero) {
		this.numeroPedido = numero;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public ItemDePedido[] getItens() {
		return itens;
	}
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Ajuda a construir e a setar os valores do OBJETO.
	public Pedido(int numeroPedido, String dataEmissao, String formaDePagamento,
			double valorTotal, String situacao, Endereco enderecoEntrega) {
		super();
		this.numeroPedido = numeroPedido;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		this.enderecoEntrega = enderecoEntrega;
	}
	public boolean inserirItem(ItemDePedido item) {
		for  (int i = 0; i < itens.length; i++) {
			if (itens[i] == null) {
				itens[i] = item;
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		
		Locale local = new Locale("pt", "BR");
		
		retValue = "Informacoes sobre Pedido: " + ENTER + 
		"Numero do Pedido: " + numeroPedido + ENTER + 
		"Data de Emissao: " + dataEmissao + ENTER + 
		"Forma de pagamento: " + formaDePagamento + ENTER + 
		"Valor Total: " + 
				NumberFormat.getCurrencyInstance(local).format(this.valorTotal) +
				ENTER +
		"Situacao: " + situacao + ENTER +
		"Endereco de Entrega: " + ENTER +
		"Itens: ";
		for (int i = 0; i < itens.length; i++) {
			retValue += itens[i] + ENTER;
		}
		return retValue;
	}
	
}
