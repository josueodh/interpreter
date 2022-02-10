
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Interpretador {
    private InterpretadorExpressao interpretadorInicial;

    public Interpretador(String contexto) {

        Stack<InterpretadorExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new Numero(Double.parseDouble(elemento)));
            }  else if (elemento.equals("^")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                Numero elementoEsquerda = (Numero) pilhaInterpretadores.pop();
                Numero elementoDireita = new Numero(Double.parseDouble(iterator.next()));
                Potencia interpretador = new Potencia(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            } else if (elemento.equals("%")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                Numero elementoEsquerda = (Numero) pilhaInterpretadores.pop();
                Numero elementoDireita = new Numero(Double.parseDouble(iterator.next()));
                RestoDivisao interpretador = new RestoDivisao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            }else if (elemento.equals("√")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                Numero elementoEsquerda = (Numero) pilhaInterpretadores.pop();
                Numero elementoDireita = new Numero(Double.parseDouble(iterator.next()));
                Raiz interpretador = new Raiz(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorInicial.interpretar();
    }

}
