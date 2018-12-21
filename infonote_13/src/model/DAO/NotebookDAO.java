package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Notebook;
import util.Conexao;
import util.Configurador;

public class NotebookDAO {
	
	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;
	
	public NotebookDAO() {
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}
	
	public static Notebook inserir(String serialnote, String modelo, String descricao,
			int estoque, Double precoUnitario, String figura, String dataCadastro) {
		
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		
		try {
			// Criação do insert
			String sql = "insert into notebook (serialnote, modelo, descricao, estoque, precoUnitario, figura, dataCadastro) values (?,?,?,?,?,?,?)";
			
			// Obter a conexao com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			
			// Abrir a conexao
			Connection con = conex.obterConexao();
			
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setString(1,serialnote);
			comando.setString(2,modelo);
			comando.setString(3,descricao);
			comando.setInt(4,estoque);
			comando.setDouble(5,precoUnitario);
			comando.setString(6,figura);
			comando.setString(7,dataCadastro);
			
			// Comando executado
			comando.executeUpdate();
	
		} catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		notebook = new Notebook (serialnote, modelo, descricao, estoque, 
				precoUnitario, figura, dataCadastro);
		return notebook;
	}
	
	public static Notebook[] buscarTodos() {
		Notebook[] Notebooks = null;
		NotebookDAO noteDAO = new NotebookDAO();
		
		try {
			//Criacao do select
			String sql = "Select * from Notebook";
			
			// Obter a conexao com o banco de dados
			Conexao conex = new Conexao (noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			
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
						rs.getString("serialnote"),
						rs.getString("modelo"),
						rs.getString("descricao"),
						rs.getInt("estoque"),
						rs.getDouble("precoUnitario"),
						rs.getString("figura"),
						rs.getString("dataCadastro"));
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
	
	public static Notebook excluir(String serialnote){
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			// Criação do insert
			String sql = "delete from notebook where serialnote = ?";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1,serialnote);
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return notebook;
	}		
	
	public static Notebook atualizar(String serialnote, String descricao, int estoque, double precoUnitario, String figura, String dataCadastro){
		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			// Criação do update
			//exceto serialnote e modelo
			String sql = "update notebook set "
					+ " descricao = ?, estoque = ?, precoUnitario = ?, "
					+ " figura = ?, dataCadastro = ? "
					+ " where "
					+ " serialnote = ? ";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);			
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1,descricao);
			comando.setInt(2,estoque);
			comando.setDouble(3,precoUnitario);
			comando.setString(4,figura);
			comando.setString(5,dataCadastro);
			comando.setString(6,serialnote);
				
			
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}	

}
