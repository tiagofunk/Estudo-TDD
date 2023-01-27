package tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import src.CamelCase;

public class TesteCamelCase {

    @Test
    public void testarNome() {
        assertArrayEquals(
            new String[] { "nome" },
            CamelCase.converterCamelCase("nome").toArray()
        );
    }

    @Test
    public void testarNomeIniciandoComMaiuscula() {
        assertArrayEquals(
            new String[] { "nome" },
            CamelCase.converterCamelCase("Nome").toArray()
        );
    }

    @Test
    public void testarNomeComposto() {
        assertArrayEquals(
            new String[] { "nome","composto" },
            CamelCase.converterCamelCase("nomeComposto").toArray()
        );
    }

    @Test
    public void testarNomeCompostoIniciandoComMaiuscula() {
        assertArrayEquals(
            new String[] { "nome","composto" },
            CamelCase.converterCamelCase("NomeComposto").toArray()
        );
    }

    @Test
    public void testarCPFSozinho() {
        assertArrayEquals(
            new String[] { "CPF" },
            CamelCase.converterCamelCase("CPF").toArray()
        );
    }

    @Test
    public void testarCPFNoFinal() {
        assertArrayEquals(
            new String[] { "numero","CPF" },
            CamelCase.converterCamelCase("numeroCPF").toArray()
        );
    }

    @Test
    public void testarCPFNoMeio() {
        assertArrayEquals(
            new String[] { "numero","CPF", "contribuinte" },
            CamelCase.converterCamelCase("numeroCPFContribuinte").toArray()
        );
    }

    @Test
    public void testarNumeroNoMeio() {
        assertArrayEquals(
            new String[] { "recupera", "10", "primeiros"  },
            CamelCase.converterCamelCase("recupera10Primeiros").toArray()
        );
    }

    @Test
    public void testarNumeroComCPF() {
        assertArrayEquals(
            new String[] { "recupera", "10", "CPF", "primeiros"  },
            CamelCase.converterCamelCase("recupera10CPFPrimeiros").toArray()
        );
    }

    @Test
    public void testarCPFComNumero() {
        assertArrayEquals(
            new String[] { "rec", "CPF", "10", "pri"  },
            CamelCase.converterCamelCase("recCPF10Pri").toArray()
        );
    }

    @Test
    public void testarCPFComNumero2() {
        assertArrayEquals(
            new String[] { "abc", "d"  },
            CamelCase.converterCamelCase("abcD").toArray()
        );
    }

    @Test(expected = InvalidIdException.class)
    public void testarIniciandoComNumero(){
        CamelCase.converterCamelCase("10Primeiros");
    }

    @Test(expected = InvalidIdException.class)
    public void testarCaracterInvalido(){
        CamelCase.converterCamelCase("nome#Composto");
    }
}
