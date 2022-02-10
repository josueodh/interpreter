public class Potencia implements InterpretadorExpressao{
    private double x;
    private double y;

    public Potencia (Numero elementoEsquerda, Numero elementoDireita) {
        x = elementoEsquerda.getNumero();
        y = elementoDireita.getNumero();
    }

    public double interpretar() {
        return  Math.pow(x, y);
    }
}
