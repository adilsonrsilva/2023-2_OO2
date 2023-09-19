package pessoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaJDBCDAO implements PessoaDAO {
	
	private  String URL = "jdbc:mysql://localhost/livros";
	private  String USERNAME = "userbanco";
	private  String PASSWORD = "1User#Banco@sql";
	private Connection connection;
	
    public PessoaJDBCDAO(Connection connection) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    	this.connection = connection;
    }
	    

    public PessoaJDBCDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
	@Override
	public Pessoa getPessoaById(int id) {
		Pessoa pessoa = new Pessoa();
		try {
			Statement statement = connection.createStatement();
			String SQL = "SELECT * FROM pessoa WHERE id = " + id;
			System.out.println(SQL);
			ResultSet resultSet = statement.executeQuery(SQL);
			
			while (resultSet.next()) {
				pessoa.setId(resultSet.getInt("id"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setIdade(resultSet.getInt("idade"));
				pessoa.setEmail(resultSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pessoa;
	}

		
	@Override
	public void incluiPessoa(Pessoa pessoa) {
		try {
			String SQL = "INSERT INTO pessoa (nome, idade, email) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setString(1, pessoa.getNome());
			statement.setInt(2, pessoa.getIdade());
			statement.setString(3, pessoa.getEmail());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alteraPessoa(int id, Pessoa pessoa) {
		try {
			Statement statement = connection.createStatement();
			String SQL = "UPDATE pessoa SET nome = '" + pessoa.getNome() + 
					                   "', idade = " + pessoa.getIdade() +
					                    ", email = '" + pessoa.getEmail() +
					                    "' WHERE id = " + id;
			System.out.println(SQL);
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluiPessoa(int id) {
		try {
			Statement statement = connection.createStatement();
			String SQL = "delete from pessoa where id = " + id;
			System.out.println(SQL);
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Pessoa> getAllPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String SQL = "SELECT * FROM pessoa";
			System.out.println(SQL);
			ResultSet resultset = statement.executeQuery(SQL);
			
			while (resultset.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultset.getInt("id"));
				pessoa.setNome(resultset.getString("nome"));
				pessoa.setIdade(resultset.getInt("idade"));
				pessoa.setEmail(resultset.getString("email"));
				System.out.println(pessoa.comoTexto());
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return pessoas;
	}
}
