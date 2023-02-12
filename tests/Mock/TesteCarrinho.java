package tests.Mock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.Mock.CarrinhoCompras;
import src.Mock.MockObservadorCarrinho;
import src.Mock.Produto;

public class TesteCarrinho {
    
    @Test
    public void totalCarrinho(){
        CarrinhoCompras c = new CarrinhoCompras();
        c.adicionarObservador(new MockObservadorCarrinho());
        c.adicionarProduto(new Produto("Tẽnis", 100));
        c.adicionarProduto(new Produto("Camiseta", 50));
        c.adicionarProduto(new Produto("Bermuda", 70));
        assertEquals(220, c.calculaTotal());
    }

    @Test
    public void escutaAdicaoProduto(){
        CarrinhoCompras c = new CarrinhoCompras();
        MockObservadorCarrinho mock = new MockObservadorCarrinho();
        c.adicionarObservador(mock);
        c.adicionarProduto(new Produto("Tênis", 100));
        mock.verificaRecebimentoProduto("Tênis", 100);
    }
}
