package infnet.spring.boot.tp1.service;

import infnet.spring.boot.tp1.dto.CalculationChangeDTO;
import infnet.spring.boot.tp1.dto.CalculationDTO;
import infnet.spring.boot.tp1.entity.Calculation;

import java.util.List;

public interface CalculationService {

    Calculation calculate(CalculationDTO calculationDTO);
    List<Calculation> findAllCalculations(String typeCalculate);
    Calculation changeCalculate(Long id, CalculationChangeDTO calculationChangeDTO);
    void deleteCalculation(Long id);
}
