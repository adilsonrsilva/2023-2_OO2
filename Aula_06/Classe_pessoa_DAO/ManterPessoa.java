package pessoa;

import java.util.ArrayList;
import java.util.List;

public class ManterPessoa {

	public static void main (String args[]) {
		
		//IncluiPessoa
//		Pessoa pessoaNova = new Pessoa("Joana", 25, "joana@gmail.com");
//		new PessoaJDBCDAO().incluiPessoa(pessoaNova);
		
		
		//AlteraPessoa
//		Pessoa pessoaAlterar = new Pessoa("Mario", 30 ,"mario@gmail.com");
//		new PessoaJDBCDAO().alteraPessoa(3, pessoaAlterar);
		
		
		//ExcluiPessoa
//		new PessoaJDBCDAO().excluiPessoa(9);

		
		//SelecionaPessoa
//		Pessoa pessoaSelecionada = new PessoaJDBCDAO().getPessoaById(3);
//		System.out.println(pessoaSelecionada.comoTexto());
		
		
		
		//ListarPessoa
		PessoaJDBCDAO pessoa = new PessoaJDBCDAO();
		pessoa.getAllPessoas();
		
		
	}
	
}
