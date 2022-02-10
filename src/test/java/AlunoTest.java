import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class AlunoTest {

    @Test
    void deveCalcularExpressaoComFormula() {
        Aluno aluno = new Aluno();
        aluno.setNota1(2.0);
        aluno.setNota2(2.0);

        assertEquals(4.0, aluno.calcularNota());
    }

}