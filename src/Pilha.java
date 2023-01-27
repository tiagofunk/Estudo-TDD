package src;

public class Pilha {

    private int tamanho = 0;
    private String[] elementos;

    public Pilha(int maximo){
        this.elementos = new String[10];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void empilha(String string) {
        if( this.tamanho >= this.elementos.length ){
            throw new PilhaCheiaException();
        }
        this.elementos[ this.tamanho ] = string;
        this.tamanho++;
    }

    public Object topo() {
        return this.elementos[ this.tamanho-1 ];
    }

    public String desempilha() {
        if( this.estaVazia() ){
            throw new PilhaVaziaException();
        }
        this.tamanho--;
        String elemento = this.elementos[ this.tamanho ];
        return elemento;
    }

}
