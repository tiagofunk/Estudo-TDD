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

    @Test
    public void adicionarDoisObservadores(){
        CarrinhoCompras c = new CarrinhoCompras();
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        c.adicionarObservador(mock1);
        c.adicionarObservador(mock2);
        c.adicionarProduto(new Produto("Tênis", 100));
        mock1.verificaRecebimentoProduto("Tênis", 100);
        mock2.verificaRecebimentoProduto("Tênis", 100);
    }
}
