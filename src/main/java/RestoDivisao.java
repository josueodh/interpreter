public class RestoDivisao implements InterpretadorExpressao {

    private double x;
    private double y;

    public RestoDivisao (Numero elementoEsquerda, Numero elementoDireita) {
        x = elementoEsquerda.getNumero();
        y = elementoDireita.getNumero();
    }

    public double interpretar() {
        return x % y;
    }
}