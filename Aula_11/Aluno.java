package aula11;


public class Aluno {

    private int id;
    private String nome;
    private int idade;
    private String email;
	
    public Aluno() {
	}
    
    public Aluno(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

    public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
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


	
	public static void main (String args[]) {
		Conexao.getInstancia();
		Conexao.selecionaAluno(3);
		Conexao.IncluirAluno("aluuno3", 20, "aluno333@email.com");
		
		
	}
}