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
public class CalculationChangeDTO {

    @JsonIgnore
    private double id;
    private double valueX;
    private double valueY;
    private String typeCalculation;

}
