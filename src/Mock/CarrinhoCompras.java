package src.Mock;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    
    private ObservadorCarrinho observadorCarrinho;
    private List<Produto> itens = new ArrayList<>();

    public void adicionarProduto(Produto p){
        itens.add(p);
        this.observadorCarrinho.produtoAdicionado(p.getNome(), p.getValor());
    }

    public int calculaTotal(){
        int total = 0;
        for(Produto p:itens){
            total += p.getValor();
        }
        return total;
    }

    public void adicionarObservador(ObservadorCarrinho observadorCarrinho) {
        this.observadorCarrinho = observadorCarrinho;
    }
}
