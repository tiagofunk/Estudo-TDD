package src;

public class Pilha {

    private int tamanho;
    private String topo;

    public Pilha(){
        this.tamanho = 0;
        this.topo = null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void empilha(String string) {
        this.tamanho++;
        this.topo = string;
    }

    public Object topo() {
        return this.topo;
    }

}
