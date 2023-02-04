package src.SAB;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Biblioteca {
	private String nome;
	private int numeroUnico = 0;
	private TreeSet<Livro> repositorioLivros;
	private HashSet<Usuario> usuarios;

	public Biblioteca(String nome) {
		this.nome = nome;
		repositorioLivros = new TreeSet<Livro>();
		usuarios = new HashSet<Usuario>();
	}

	private void verificaNoAdicionarLivroCatalogo(Livro livro) throws AdicionarLivroInexistenteException{
		if( livro == null ){
			throw new AdicionarLivroInexistenteException("--->Nâo pode adicionar livro inexistente!");
		}
	}

	public void adicionaLivroCatalogo(Livro livro) throws AdicionarLivroInexistenteException {
		verificaNoAdicionarLivroCatalogo(livro);
		livro.setNumeroCatalogo(this.getNumericoUnico());
		repositorioLivros.add(livro);
	}

	private void verificaNoVerificaUsuario(String nome) throws UsuarioInexistenteException, UsuarioComNomeVazioException, UsuarioJaRegistradoException{
		if( nome == null ){
			throw new UsuarioInexistenteException("--->Não pode registrar usuario inexistente!");
		}
		if( nome.isEmpty() ){
			throw new UsuarioComNomeVazioException("--->Não pode registrar usuario com nome vazio!");
		}
		Usuario usuario = new Usuario(nome);
		if (usuarios.contains(usuario)) {
			throw new UsuarioJaRegistradoException("--->Já existe usuário com o nome \""+ nome + "\"! Use outro nome!");	
		}
	}

	public void registraUsuario(String nome) 
			throws UsuarioJaRegistradoException, UsuarioComNomeVazioException,
			UsuarioInexistenteException {
		verificaNoVerificaUsuario(nome);
		usuarios.add(new Usuario(nome));
	}

	private void verificaNoEmprestaLivro(Livro livro, Usuario usuario) throws LivroOuUsuarioNulosException, LivroIndisponivelParaEmprestimoException{
		if ((livro == null) && (usuario == null)){
			throw new LivroOuUsuarioNulosException("--->Livro e Usuário inexistentes!");
		}
		if (livro == null) {
			throw new LivroOuUsuarioNulosException("--->Não pode emprestar livro inexistente!");	
		}
		if( usuario == null ){
			throw new LivroOuUsuarioNulosException("--->Não pode emprestar livro a Usuário inexistente!");
		}
		if( livro.getUsuario() != null ){
			throw new LivroIndisponivelParaEmprestimoException("--->Livro " + livro + " indispon�vel para empr�stimo!");
		}
	}

	public void emprestaLivro(Livro livro, Usuario usuario)
			throws LivroIndisponivelParaEmprestimoException,
			LivroOuUsuarioNulosException {
		verificaNoEmprestaLivro(livro, usuario);
		usuario.anexaLivroAoUsuario(livro);
		livro.anexaUsuarioAoLivro(usuario);
	}

	private void verificaLivroNoDevolveLivro( Livro livro ) throws DevolveLivroNuloParaEmprestimoException, DevolveLivroDisponivelParaEmprestimoException{
		if( livro == null ){
			throw new DevolveLivroNuloParaEmprestimoException("--->Não pode emprestar livro inexistente!");
		}
		if (livro.getUsuario() == null) {
			throw new DevolveLivroDisponivelParaEmprestimoException("---> Tentou devolver livro " + livro+ " que está disponível para empréstimo!");
		}
	}

	public void devolveLivro(Livro livro)
			throws DevolveLivroDisponivelParaEmprestimoException,
			DevolveLivroNuloParaEmprestimoException {
		verificaLivroNoDevolveLivro(livro);
		Usuario usuario = livro.getUsuario();
		usuario.desanexaLivroDoUsuario(livro);
		livro.desanexaUsuarioDoLivro();	
	}

	public Livro buscaLivroPorNumeroCatalogo(int numeroUnico) {
		Livro livroAchado = null;
		Iterator<Livro> iter = repositorioLivros.iterator();
		while ( iter.hasNext() && livroAchado == null ) {
			Livro livro = (Livro) iter.next();
			int numeroUnicoLivro = livro.getNumeroCatalogo();
			if (numeroUnicoLivro == numeroUnico){
				livroAchado = livro;
			}
		}
		return livroAchado;
	}

	private void verificarNoBuscaLivroPorTituloAutor(String titulo, String autor) throws TituloOuAutorNuloException, TituloOuAutorVazioException{
		if( titulo == null || autor == null ){
			throw new TituloOuAutorNuloException("--->Nome do titulo e/ou do autor é(são) nulo(s)<<<");
		}
		if( titulo.isEmpty() || autor.isEmpty() ){
			throw new TituloOuAutorVazioException("--->Nome do titulo e/ou do autor é(são) vazio(s)<<<");
		}
	}

	public Livro buscaLivroPorTituloAutor(String titulo, String autor)
			throws TituloOuAutorVazioException, TituloOuAutorNuloException {
		verificarNoBuscaLivroPorTituloAutor(titulo, autor);
		Livro livroAchado = null;
		Iterator<Livro> iter = repositorioLivros.iterator();
		while ( iter.hasNext() && livroAchado == null ) {
			Livro livro = (Livro) iter.next();
			String oTitulo = livro.getTitulo();
			String oAutor = livro.getAutor();
			if (oTitulo.equals(titulo) && oAutor.equals(autor)) {
				livroAchado = livro;
			}
		}
		return livroAchado;
	}

	private void verificaNoBuscaUsuarioPorNome(String nome) throws BuscaUsuarioComNomeNuloException, BuscaUsuarioComNomeVazioException{
		if( nome == null ){
			throw new BuscaUsuarioComNomeNuloException("--->Nome do usuário é nulo<<<");
		}
		if( nome.isEmpty() ){
			throw new BuscaUsuarioComNomeVazioException("--->Nome do usuário é vazio<<<");
		}
	}

	public Usuario buscaUsuarioPorNome(String nome)
			throws BuscaUsuarioComNomeVazioException,
			BuscaUsuarioComNomeNuloException {
		verificaNoBuscaUsuarioPorNome(nome);
		Usuario usuarioAchado = null;
		Iterator<Usuario> iter = usuarios.iterator();
		while ( iter.hasNext() && usuarioAchado == null) {
			Usuario usuario = (Usuario) iter.next();
			String oNome = usuario.getNome();
			if (oNome == nome) {
				usuarioAchado = usuario;
			}
		}
		return usuarioAchado;
	}

	public void exibeLivrosDisponiveis() {
		System.out.println("Biblioteca: " + nome);
		System.out.println(">>>Livros Disponíveis para Empréstimo<<<");
		if( repositorioLivros.isEmpty()){
			System.out.println("---> Nenhum livro no repositório");
			return ;
		}
		Iterator<Livro> iter = repositorioLivros.iterator();
		while (iter.hasNext()) {
			Livro livro = (Livro) iter.next();
			if (livro.getUsuario() == null) {
				livro.exibe();
			}
		}
		System.out.println("<<< Livros Disponíveis >>>");
		System.out.println();
	}

	public void exibeLivrosEmprestados() {
		System.out.println("Biblioteca: " + nome);
		System.out.println(">>>Livros Emprestados<<<");
		if( repositorioLivros.isEmpty() ){
			System.out.println("---> Nenhum livro no repositório");
			return ;
		}
		Iterator<Livro> iter = repositorioLivros.iterator();
		while (iter.hasNext()) {
			Livro livro = (Livro) iter.next();
			if (livro.getUsuario() != null) {
				System.out.println("\t\t--------------------------------------------");
				livro.exibe();
			}
		}	
		System.out.println("<<< Livros Emprestados >>>");
		System.out.println();
	}

	public void exibeUsuarios() {
		System.out.println("Biblioteca: " + nome);
		System.out.println(">>>Usuários da Biblioteca<<<");
		if( usuarios.isEmpty() ){
			System.out.println("---> Nenhum usu�rio na Biblioteca");
			return;
		}
		Iterator<Usuario> iter = usuarios.iterator();
		while (iter.hasNext()) {
			Usuario usuario = (Usuario) iter.next();
			usuario.exibe();
		}
		System.out.println("<<< Usuários >>>");
		System.out.println();
	}

	private int getNumericoUnico() {
		return numeroUnico = numeroUnico + 1;
	}

	public int sizeRepositorioLivros() {
		return repositorioLivros.size();
	}

	public int sizeUsuarios() {
		return usuarios.size();
	}
}
