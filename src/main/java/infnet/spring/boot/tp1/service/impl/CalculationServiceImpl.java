package infnet.spring.boot.tp1.service.impl;

import infnet.spring.boot.tp1.dto.CalculationDTO;
import infnet.spring.boot.tp1.entity.Calculation;
import infnet.spring.boot.tp1.service.CalculationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CalculationServiceImpl implements CalculationService {

    HashMap<Long, Calculation> calculationMap = new HashMap<>();

    private static long currentId = 0;

    public static synchronized long generateNewId() {
        return ++currentId;
    }

    @Override
    public Calculation calculate(CalculationDTO calculationDTO) {
        Calculation calculation = new Calculation();
        BeanUtils.copyProperties(calculationDTO, calculation);
        calculation.performCalculation();
        return calculationMap.put(generateNewId(), calculation);
    }

    @Override
    public List<Calculation> findAllCalculations(String typeCalculate) {
        var calculations = calculationMap.values().stream().toList();
        if(Strings.isNotBlank(typeCalculate)) {
            calculations = calculationMap.values().stream().filter(calc -> calc.getTypeCalculation().equals(typeCalculate)).toList();
        }
        return calculations;
    }
}
