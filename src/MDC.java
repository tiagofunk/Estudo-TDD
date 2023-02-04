package src;

public class MDC {
	private static final int[] PRIMOS = { 2, 3, 5, 7, 11, 13, 17, 19 };

	private static boolean saoValidos(int numeros[]){
		for (int i : numeros) {
			if( i < 1 ) return false;
		}
		return true;
	}

	private static int contarDivisoes(int numeros[], int numeroPrimo){
		int contador = 0;
		for (int i = 0; i < numeros.length; i++ ) {
			if( numeros[i] % numeroPrimo == 0 ){
				numeros[i] /= numeroPrimo;
				contador++;
			}
		}
		return contador;
	}

	private static boolean todosTemValorUm( int numeros[] ){
		for (int i : numeros) {
			if( i != 1 ) return false;
		}
		return true;
	}

	public static int mdc(int numeros[]) {
		if( !saoValidos(numeros) ) return -1;
		int mdc = 1;
		int posicaoPrimoAtual = 0;
		while( posicaoPrimoAtual < PRIMOS.length){
			int contador = contarDivisoes(numeros, PRIMOS[posicaoPrimoAtual]);
			if (contador == numeros.length) {
				mdc *= PRIMOS[posicaoPrimoAtual];
			}
			if (contador == 0) {
				posicaoPrimoAtual++;
			}
			if (todosTemValorUm(numeros)) {
				break;
			}
		}
		return mdc;
	}
}