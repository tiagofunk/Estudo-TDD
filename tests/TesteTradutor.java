package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.Tradutor;

public class TesteTradutor{

    private Tradutor t;

    @Before
    public void criarTradutor(){
        t = new Tradutor();
    }

    @Test
    public void semPalavra(){
        assertTrue(t.estaVazio());
    }

    @Test
    public void umaTraducao(){
        t.adicionarTraducao("bom","good");
        assertFalse(t.estaVazio());
        assertEquals("good", t.traduzir("bom"));
    }

    @Test
    public void duasTraducoes(){
        t.adicionarTraducao("bom","good");
        t.adicionarTraducao("mau","bad");
        assertEquals("good", t.traduzir("bom"));
        assertEquals("bad", t.traduzir("mau"));
    }

    @Test
    public void duasTraducoesMesmaPalavra(){
        t.adicionarTraducao("bom","good");
        t.adicionarTraducao("bom","nice");
        assertEquals("good, nice", t.traduzir("bom"));
    }

    @Test
    public void umaFrase(){
        t.adicionarTraducao("guerra", "war");
        t.adicionarTraducao("é", "is");
        t.adicionarTraducao("ruim", "bad");
        assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
    }

    @Test
    public void umaFraseDuasPalavrasMesmaTraducao(){
        t.adicionarTraducao("paz", "peace");
        t.adicionarTraducao("é", "is");
        t.adicionarTraducao("bom", "good");
        t.adicionarTraducao("bom", "nice");
        assertEquals("peace is good", t.traduzirFrase("paz é bom"));
    }
}