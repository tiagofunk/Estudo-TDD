package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.MDC;

public class TesteMDC {

    @Test
    public void testarMDCComDoisNumeros(){
        assertEquals(6, MDC.mdc(new int[]{18, 60}));
        assertEquals(4, MDC.mdc(new int[]{20, 24}));
        assertEquals(80, MDC.mdc(new int[]{400, 320}));
    }

    @Test
    public void testarMDCComTresNumeros(){
        assertEquals(3, MDC.mdc(new int[]{6,12,15}));
        assertEquals(12, MDC.mdc(new int[]{120,144,60}));
        assertEquals(270, MDC.mdc(new int[]{540,810,1080}));
    }

    @Test
    public void testarERRO_MDC(){
        assertEquals(-1, MDC.mdc(new int[]{20, 0}));
    }

    @Test
    public void testarMDC_Duplicado(){
        assertEquals(20, MDC.mdc(new int[]{20, 20}));
    }
    
}
