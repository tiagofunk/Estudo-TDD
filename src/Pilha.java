package src;

import java.util.ArrayList;
import java.util.List;

public class Pilha {

    private int tamanho = 0;
    private String[] elementos = new String[10];

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void empilha(String string) {
        this.elementos[ this.tamanho ] = string;
        this.tamanho++;
    }

    public Object topo() {
        return this.elementos[ this.tamanho-1 ];
    }

    public String desempilha() {
        this.tamanho--;
        String elemento = this.elementos[ this.tamanho ];
        return elemento;
    }

}
