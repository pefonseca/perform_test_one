package infnet.spring.boot.tp1.entity;

import infnet.spring.boot.tp1.operation.AdditionOperation;
import infnet.spring.boot.tp1.operation.DivideOperation;
import infnet.spring.boot.tp1.operation.ExponentiationOperation;
import infnet.spring.boot.tp1.operation.MultiplyOperation;
import infnet.spring.boot.tp1.operation.Operation;
import infnet.spring.boot.tp1.operation.SubtractOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calculation {

    private Long id = generateNewId();
    private double valueX;
    private double valueY;
    private double result;
    private String typeCalculation;

    private static long currentId = 0;

    public static synchronized long generateNewId() {
        return ++currentId;
    }

    public void performCalculation() {
        Operation operation;
        switch (this.typeCalculation) {
            case "Adição":
                operation = new AdditionOperation();
                break;
            case "Subtração":
                operation = new SubtractOperation();
                break;
            case "Multiplicação":
                operation = new MultiplyOperation();
                break;
            case "Divisão":
                operation = new DivideOperation();
                break;
            case "Exponenciação":
                operation = new ExponentiationOperation();
                break;
            default:
                throw new IllegalArgumentException("Tipo de calculo invalido: " + typeCalculation);
        }
        this.result = operation.execute(this.valueX, this.valueY);
    }
}
