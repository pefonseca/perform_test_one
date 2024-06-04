package infnet.spring.boot.tp1.operation;

public class ExponentiationOperation implements Operation {
    @Override
    public double execute(double valueX, double valueY) {
        return Math.pow(valueX, valueY);
    }
}
