package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Notebook;
import model.ItemDePedido;
import model.Notebook;
import model.Pedido;
import util.Conexao;
import util.Teclado;

public class NotebookDAO {
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	private int serialNote;
	private String modelo;
	private String descricao;
	private int estoque;
	private double precoUnitario;
	private String figura;
	private String dataCadastro;
	
	@SuppressWarnings("unlikely-arg-type")
	public void inserirNotebook() {
		// Lê o notebook escolhido do teclado
		String numeroNote = Teclado.lerTexto("Informe o número do notebook" + " para compra: ");
	
		// Cria pedido
		if (pedido == null) {
			pedido = new Pedido();
		}
		// Busca notebook selecionado
		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getserialNote())) {
				aux = notebooks[i];
			}
		}
		// Se não existir, interrompe
		if (aux == null) {
			return;
		}

		// Cria item
		ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);

		// Inserir item no pedido
		pedido.inserirItem(item);
	}
	
	public static Notebook[] buscarTodos() {
		Notebook[] Notebooks = null;
		
		try {
			//Criacao do select
			String sql = "Select * from Notebook";
			
			// Obter a conexao com o banco de dados
			Conexao conex = new Conexao ("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.cj.jdbc.Driver","gabriel","1234");
			
			Connection con = conex.obterConexao();
			
			/* Executa a confirmaçao direta de acesso ao banco
			 * pois não são necessárias informações para a
			 * Query (caracter curinga)
			 */
			Statement comando = con.createStatement();
			
			/* ResultSet - Classe java que monta em memória uma matriz
			 * com a resposta das linhas do banco de dados
			 */
			ResultSet rs = comando.executeQuery(sql);
			
			// vetor de objetos
			Notebooks = new Notebook[10];
			
			/* Passagem de linha de dados do ResultSet para o vetor de objetos
			 * (uma linha de dados da matriz do ResultSet é copiada para
			 * um objeto no vetor Notebooks
			 */
			
			int i = 0;
			while (rs.next()) {
				Notebooks[i++] = new Notebook(
						rs.getInt(serialNote),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("mensagem"));
			}
			
			// É necessário encerrar o acesso ao banco para liberar a conexao
			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Notebooks;
	}

}
