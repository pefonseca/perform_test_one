package infnet.spring.boot.tp1.operation;

public class SubtractOperation implements Operation {
    @Override
    public double execute(double valueX, double valueY) {
        return valueX - valueY;
    }
}
