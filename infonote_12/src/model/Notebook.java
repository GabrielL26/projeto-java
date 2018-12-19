package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Notebook {
	
	private String serialNote;
	private String modelo;
	private String descricao;
	private int estoque;
	private double precoUnitario;
	private String figura;
	private String dataCadastro;
	
	public String getserialNote() {
		return serialNote;
	}
	public void setserialNote(String serialNote) {
		this.serialNote = serialNote;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public String getFigura() {
		return figura;
	}
	public void setFigura(String figura) {
		this.figura = figura;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Notebook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Ajuda a construir e a setar os valores do OBJETO.
	public Notebook(String serialNote, String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {
		super();
		this.serialNote = serialNote;
		this.modelo = modelo;
		this.descricao = descricao;
		this.estoque = estoque;
		this.precoUnitario = precoUnitario;
		this.figura = figura;
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		
		Locale local = new Locale("pt", "BR");
		
		retValue = "Informacoes sobre o Notebook: " + ENTER + 
		"Numero do Notebook: " + serialNote + ENTER + 
		"Modelo: " + modelo + ENTER + 
		"Descricao: " + descricao + ENTER + 
		"Estoque: " + estoque + ENTER +
		"Preco Unitario: " + 
				NumberFormat.getCurrencyInstance(local).format(this.precoUnitario) +
				ENTER + 
		"Figura: " + figura + ENTER +
		"Data de Cadastro: " + dataCadastro + ENTER;
		
		return retValue;
	}

}
