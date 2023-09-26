package pessoa;

import java.sql.*;

public class Pessoa {

    // Atributos da classe
    private String nome;
    private int idade;
    private String email;

    // Construtor da classe
    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para conectar ao banco de dados mysql
    public Connection conectar() {
        try {
            // Altere os valores de url, user e password de acordo com o seu banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost/livros";
            String user = "userbanco";
            String password = "1User#Banco@sql";
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
			System.out.println("Driver não localizado: " + e.getMessage());
			return null;
		}
    }

    // Método para inserir uma pessoa no banco de dados
    public void inserir() {
        try {
            Connection con = conectar();
            if (con != null) {
                String sql = "INSERT INTO pessoa (nome, idade, email) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.setInt(2, this.idade);
                ps.setString(3, this.email);
                ps.executeUpdate();
                ps.close();
                con.close();
                System.out.println("Pessoa inserida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa no banco de dados: " + e.getMessage());
        }
    }

    // Método para atualizar uma pessoa no banco de dados
    public void atualizar() {
        try {
            Connection con = conectar();
            if (con != null) {
                String sql = "UPDATE pessoa SET nome = ?, idade = ?, email = ? WHERE nome = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.setInt(2, this.idade);
                ps.setString(3, this.email);
                ps.setString(4, this.nome);
                ps.executeUpdate();
                ps.close();
                con.close();
                System.out.println("Pessoa atualizada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa no banco de dados: " + e.getMessage());
        }
    }

    // Método para deletar uma pessoa no banco de dados
    public void deletar() {
        try {
            Connection con = conectar();
            if (con != null) {
                String sql = "DELETE FROM pessoa WHERE nome = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, this.nome);
                ps.executeUpdate();
                ps.close();
                con.close();
                System.out.println("Pessoa deletada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pessoa no banco de dados: " + e.getMessage());
        }
    }

    // Método para consultar uma pessoa no banco de dados
    public void consultar() {
        try {
            Connection con = conectar();
            if (con != null) {
                String sql = "SELECT * FROM pessoa WHERE nome = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, this.nome);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Idade: " + rs.getInt("idade"));
                    System.out.println("Email: " + rs.getString("email"));
                } else {
                    System.out.println("Pessoa não encontrada!");
                }
                rs.close();
                ps.close();
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar pessoa no banco de dados: " + e.getMessage());
        }
    }
	
	
	// Método main para testar os métodos da classe
    public static void main(String[] args) {
    // Criando um objeto da classe Pessoa com os valores desejados
    Pessoa p1 = new Pessoa("João", 25, "joao@gmail.com");
    // Inserindo a pessoa no banco de dados
    p1.inserir();
    // Consultando a pessoa no banco de dados
    p1.consultar();
    // Alterando os valores da pessoa
    p1.setNome("Maria");
    p1.setIdade(30);
    p1.setEmail("maria@gmail.com");
    // Atualizando a pessoa no banco de dados
    p1.atualizar();
    // Consultando a pessoa no banco de dados
    p1.consultar();
    // Deletando a pessoa no banco de dados
    p1.deletar();
}
}
