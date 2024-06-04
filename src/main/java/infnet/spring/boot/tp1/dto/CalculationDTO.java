package infnet.spring.boot.tp1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CalculationDTO {

    private double valueX;
    private double valueY;
    @JsonIgnore
    private String typeCalculation;

    public CalculationDTO addition() {
        this.typeCalculation = "Adição";
        return this;
    }

    public CalculationDTO subtract() {
        this.typeCalculation = "Subtração";
        return this;
    }

    public CalculationDTO multiply() {
        this.typeCalculation = "Multiplicação";
        return this;
    }

    public CalculationDTO division() {
        this.typeCalculation = "Divisão";
        return this;
    }

    public CalculationDTO exponentiation() {
        this.typeCalculation = "Exponenciação";
        return this;
    }
}
