package src.SAB;

public class AdicionarLivroInexistenteException extends Exception {
	public AdicionarLivroInexistenteException(String message)
    {
       super(message);
    }
}