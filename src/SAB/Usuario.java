package src.SAB;

import java.util.Iterator;
import java.util.LinkedList;

public class Usuario implements Comparable<Object> {
	private String nome;
	private LinkedList<Livro> livros;

	public Usuario(String nome) {
		setNome(nome);
		livros = new LinkedList<Livro>();
	}

	public void anexaLivroAoUsuario(Livro livro) {
		if (livro != null)
			livros.add(livro);
	}

	public void desanexaLivroDoUsuario(Livro livro) {
		livros.remove(livro);
	}

	public void exibe() {
		System.out.println("\t\t" + "Nome: " + "\t\t" + getNome());
		this.exibeLivrosUsuario();
	}

	private void exibeLivrosUsuario() {
		System.out.println("\t\t" + "\\//Livros emprestados:");
		if (livros.size() != 0) {
			Iterator<Livro> iter = livros.iterator();
			while (iter.hasNext() == true) {
				Livro livro = (Livro) iter.next();
				System.out.println("\t\t\t" + livro.getNumeroCatalogo() + " "
						+ livro);
			}
		} else{
			System.out.println("\t\t" + "---> Nenhum livro emprestado");
		}
		System.out.println("\t\t" + "\\///\\///\\///");
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;

	}

	//@Override
	public int compareTo(Object obj) {
		Usuario usuario = (Usuario) obj;
		String nome = usuario.getNome();
		return nome.compareTo(nome);
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}

	@Override
	public String toString() {
		return "\"" + getNome() + "\"";
	}

	public String getNome() {
		return nome;
	}

	protected void setNome(String _nome) {
		this.nome = _nome;
	}

	public LinkedList<Livro> getLivros() {
		return livros;
	}
}
