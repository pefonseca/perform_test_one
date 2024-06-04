package infnet.spring.boot.tp1.operation;

public class DivideOperation implements Operation {
    @Override
    public double execute(double valueX, double valueY) {
        if (valueY == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return valueX / valueY;
    }
}
