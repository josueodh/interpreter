import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpretadorTest {
    @Test
    void deveCalcularExpressaoPotencia() {
        Interpretador interpretador = new Interpretador("6 ^ 2");
        assertEquals(36.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoRaiz() {
        Interpretador interpretador = new Interpretador("36 √ 2");
        assertEquals(6.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoResto() {
        Interpretador interpretador = new Interpretador("11 % 2");
        assertEquals(1.0, interpretador.interpretar());
    }


    @Test
    void deveRetonarExcecaoElementoInvalido() {
        try {
            Interpretador interpretador = new Interpretador("2 +  2");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetonarExcecaoInvalida() {
        try {
            Interpretador interpretador = new Interpretador("2 %");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        }
    }
}