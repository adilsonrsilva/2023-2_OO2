package pessoa;

import java.util.List;

public interface PessoaDAO {

	public List<Pessoa> getAllPessoas();
	
	public Pessoa getPessoaById(int id);
	
	public void incluiPessoa(Pessoa pessoa);
	
	public void alteraPessoa(int id, Pessoa pessoa);
	
	public void excluiPessoa(int id);
}