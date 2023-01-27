package src;

import java.util.ArrayList;
import java.util.List;

import tests.InvalidIdException;

public class CamelCase {

    private static boolean saoDiferentes( char c1, char c2 ){
        return Character.isUpperCase(c1) != Character.isUpperCase(c2)
            || Character.isLowerCase(c1) != Character.isLowerCase(c2)
            || Character.isDigit(c1) != Character.isDigit(c2);
    }

    private static void adicionarLista( List<String> lista, String string ){
        if( !string.isEmpty() ){
            lista.add(string);
        }
    }

    private static List<String> splitCase( String original ){
        char letraAtual, ultimaLetra = ' ';
        String aux = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < original.length(); i++) {
            letraAtual = original.charAt(i);
            if( saoDiferentes(letraAtual, ultimaLetra) ){
                adicionarLista(list, aux);
                aux="";
            }
            ultimaLetra = letraAtual;
            aux += letraAtual;
        }
        adicionarLista(list, aux);
        return list;
    }

    private static boolean eMaiuscula(String string){
        if( string.isEmpty() ){
            return false;
        }
        for (char c : string.toCharArray()) {
            if( !Character.isUpperCase(c) ){
                return false;
            }
        }
        return true;
    }

    private static boolean iniciaComNumero(String string){
        return Character.isDigit( string.charAt(0) );
    }

    private static boolean temCaracterInvalido(String string ){
        for (char c : string.toCharArray()) {
            if( !Character.isLetterOrDigit(c) ){
                return true;
            }
        }
        return false;
    }

    private static void testaInvalidade(String original){
        if( iniciaComNumero(original) || temCaracterInvalido(original) ){
            throw new InvalidIdException();
        }
    }

    private static String separarUltimaMaiuscula(String atual, List<String> lista ){
        char ultimaLetra = atual.charAt( atual.length()-1 );
        atual = (String) atual.subSequence(0, atual.length()-1 );
        lista.add(0, ultimaLetra+"");
        return atual; 
    }

    private static boolean letraMaiusculaNoFinal(String atual, List<String> lista){
        return atual.length() == 1 && lista.isEmpty();
    }

    private static boolean letraMaiusculaAntesMinusculas(String atual, List<String> lista){
        return atual.length() == 1;
    }

    private static boolean maiusculasNoFinal(String atual, List<String> lista ){
        return eMaiuscula(atual) && lista.isEmpty();
    }

    private static boolean maiusculasAntesNumero(String atual, List<String> lista ){
        return eMaiuscula(atual) && Character.isDigit( lista.get(0).charAt(0) );
    }

    private static String consomeString( List<String> lista ){
        String atual = lista.remove(0);
        if( letraMaiusculaNoFinal(atual, lista) ){
            return atual.toLowerCase();
        }else if( letraMaiusculaAntesMinusculas(atual, lista) ){
            return atual.toLowerCase() + lista.remove(0);
        }else if( maiusculasNoFinal(atual, lista) || maiusculasAntesNumero(atual, lista)){
            return atual;
        }else if( eMaiuscula(atual) ){
            return separarUltimaMaiuscula(atual, lista);
        }
        return atual;
    }

    private static List<String> realizaConversao( String original ){
        List<String> lista = splitCase(original);
        List<String> novaLista = new ArrayList<>();
        while( !lista.isEmpty() ){
            novaLista.add( consomeString(lista) );
        }
        return novaLista;
    }

    public static List<String> converterCamelCase(String original){
        testaInvalidade(original);
        return realizaConversao(original);
    }
}
