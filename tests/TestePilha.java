package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.Pilha;

public class TestePilha {
    
    @Test
    public void pilhaVazia(){
        Pilha p = new Pilha();
        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());
    }

    @Test
    public void empilhar(){
        Pilha p = new Pilha();
        p.empilha("primeiro");
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
    }
}
