package src.SAB;

public class Livro implements Comparable<Object> {
	private int numeroCatalogo;
	private String titulo;
	private String autor;
	private Usuario usuario;

	public Livro(String titulo, String autor) {
		setTitulo(titulo);
		setAutor(autor);
		desanexaUsuarioDoLivro();
	}

	public void anexaUsuarioAoLivro(Usuario usuario) {
		this.usuario = usuario;
	}

	public void desanexaUsuarioDoLivro() {
		anexaUsuarioAoLivro(null);
	}

	public void exibe() {
		System.out.println("\t\tTítulo: \t\t" + this.getTitulo());
		System.out.println("\t\tAutor: \t\t\t" + this.getAutor());
		System.out.println("\t\tNr. Catálogo: \t\t" + this.getNumeroCatalogo());
		if (getUsuario() != null)
			System.out.println("\t\tQuem Emprestou: \t" + this.getUsuario());
		System.out.println("\t\t--------------------------------------------");
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}

	@Override
	public int compareTo(Object obj) {
		Livro livro = (Livro) obj;
		int livroNrCatalogo = livro.getNumeroCatalogo();
		int result;
		if (numeroCatalogo < livroNrCatalogo) result = -1;
		else if (numeroCatalogo == livroNrCatalogo) result = 0;
		else result = 1;
		return result;
	}

	@Override
	public int hashCode() {
		Integer integerNrCatalogo = Integer.valueOf(numeroCatalogo);
		return integerNrCatalogo.hashCode();
	}

	@Override
	public String toString() {
		return "\"Título: " + getTitulo() + " é Autor: " + getAutor() + "\"";
	}

	public int getNumeroCatalogo() {
		return numeroCatalogo;
	}

	protected void setNumeroCatalogo(int nrCatalogo) {
		numeroCatalogo = nrCatalogo;
	}

	public String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getAutor() {
		return autor;
	}

	protected void setAutor(String autor) {
		this.autor = autor;
	}
}
