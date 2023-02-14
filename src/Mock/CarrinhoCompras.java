package src.Mock;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    
    private List<ObservadorCarrinho> observadores = new ArrayList<>();
    private List<Produto> itens = new ArrayList<>();

    public void adicionarProduto(Produto p){
        itens.add(p);
        for( ObservadorCarrinho obs: observadores ){
            obs.produtoAdicionado(p.getNome(), p.getValor());
        }
    }

    public int calculaTotal(){
        int total = 0;
        for(Produto p:itens){
            total += p.getValor();
        }
        return total;
    }

    public void adicionarObservador(ObservadorCarrinho observador) {
        this.observadores.add(observador);
    }
}
