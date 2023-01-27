package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import src.Pilha;
import src.PilhaCheiaException;
import src.PilhaVaziaException;

public class TestePilha {

    private Pilha p;
    private final int TAMANHO_PILHA = 10;


    @Before
    public void inicializaPilha(){
        p = new Pilha(TAMANHO_PILHA);
    }
    
    @Test
    public void pilhaVazia(){
        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());
    }

    @Test
    public void empilhar(){
        p.empilha("primeiro");
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
    }

    @Test
    public void empilharDuplo(){
        p.empilha("primeiro");
        p.empilha("segundo");
        assertFalse(p.estaVazia());
        assertEquals(2, p.tamanho());
        assertEquals("segundo", p.topo());
    }

    @Test
    public void empilharDesempilha(){
        p.empilha("primeiro");
        p.empilha("segundo");
        String desempilhado = p.desempilha();
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
        assertEquals("segundo", desempilhado);
    }

    @Test(expected = PilhaVaziaException.class)
    public void removeVazio(){
        p.desempilha();
    }

    @Test
    public void adicionaCheio(){
        for (int i = 0; i < TAMANHO_PILHA; i++) {
            p.empilha( i+"" );
        }
        try{
            p.empilha("erro");
            fail();
        }catch(PilhaCheiaException e){
            
        }
    }
}
