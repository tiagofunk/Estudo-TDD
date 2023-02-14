package tests.Mock;

import src.Mock.ObservadorCarrinho;

public class MockObservadorCarrinhoComErro implements ObservadorCarrinho {

    @Override
    public void produtoAdicionado(String nome, int valor) {
        throw new RuntimeException("Problema Simulado pelo mock");
    }

}
