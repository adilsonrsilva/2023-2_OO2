package pessoa;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private String email;

    public Pessoa(int id, String nome, int idade, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setEmail(email);
    }

    public Pessoa(String nome, int idade, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setEmail(email);
    }
    
    
    
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	public String comoTexto() {
		return "Nome: " + nome + ", idade: " + idade + ", email: " + email;
	}
		
}