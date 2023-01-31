package src;

import java.util.HashMap;

public class Tradutor {

    private HashMap<String, String> dicionario = new HashMap<>();

    public boolean estaVazio() {
        return dicionario.isEmpty();
    }

    public void adicionarTraducao(String palavra, String traducao) {
        if( dicionario.containsKey(palavra) ){
            dicionario.put(palavra, dicionario.get(palavra)+", "+traducao);
        }else{
            dicionario.put(palavra, traducao);
        }
    }

    public String traduzir(String palavra) {
        return dicionario.get(palavra);
    }

    private String primeiraTraducao( String palavra ){
        return this.traduzir(palavra).split(",")[0];
    }

    public String traduzirFrase(String frase) {
        String fraseTraduzida = "";
        String[] palavras = frase.split(" ");
        for (String palavraAtual : palavras) {
            fraseTraduzida +=  this.primeiraTraducao(palavraAtual) + " ";
        }
        return fraseTraduzida.trim();
    }

}
