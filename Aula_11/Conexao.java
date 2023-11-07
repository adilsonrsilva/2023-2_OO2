package aula11;

import java.sql.*;

public class Conexao {

	private  String URL = "jdbc:mysql://localhost/livros";
	private  String USERNAME = "userbanco";
	private  String PASSWORD = "1User#Banco@sql";
	private static Connection connection;
	private static Conexao instancia = null;
	
	private Conexao(Connection connection) {
	    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    	Conexao.connection = connection;
	}
	
	private Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	public static Conexao getInstancia() {
		if (instancia == null) {
			instancia = new Conexao();
		}
		return instancia;
	}
	
	public static void selecionaAluno(int id) {
		Aluno aluno = new Aluno();
		try {
			//Conexao.getInstancia();
			Statement statament = connection.createStatement();
			String sql = "SELECT * FROM pessoa WHERE id = " + id;
			System.out.println(sql);
			ResultSet resultset = statament.executeQuery(sql);
			while (resultset.next()) {
				aluno.setId(resultset.getInt("id"));
				aluno.setNome(resultset.getString("nome"));
				aluno.setIdade(resultset.getInt("idade"));
				aluno.setEmail(resultset.getString("email"));
				
				System.out.println("nome: " + aluno.getNome());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void IncluirAluno(String nome, int idade, String email) {
		Aluno aluno = new Aluno(nome, idade, email);
		try {
			//Conexao.getInstancia();
			String SQL = "INSERT INTO pessoa (nome, idade, email) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setString(1, aluno.getNome());
			statement.setInt(2, aluno.getIdade());
			statement.setString(3, aluno.getEmail());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}