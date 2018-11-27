package model;

public class Pedido {

	private int numero;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Ajuda a construir e a setar os valores do OBJETO.
	public Pedido(int numero, String dataEmissao, String formaDePagamento, double valorTotal, String situacao) {
		super();
		this.numero = numero;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
	}
	
	//Mostrar para ser chamado no TESTE e da a saída.
	public void mostrar() {
		System.out.println("PEDIDO.");
		System.out.println("Número: " + numero);
		System.out.println("Data de Emissão: " + dataEmissao);
		System.out.println("Forma de Pagamento: " + formaDePagamento);
		System.out.println("Valor Total: " + valorTotal);
		System.out.println("Situação: " + situacao);
	}
	
	
}
