public class Raiz implements InterpretadorExpressao{
    private double x;
    private double y;

    public Raiz (Numero elementoEsquerda, Numero elementoDireita) {
        x = elementoEsquerda.getNumero();
        y = elementoDireita.getNumero();
    }

    public double interpretar() {
        return  Math.pow(x, 1.0/y);
    }
}
