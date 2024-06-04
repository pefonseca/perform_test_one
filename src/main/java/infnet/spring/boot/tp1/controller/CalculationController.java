package infnet.spring.boot.tp1.controller;

import infnet.spring.boot.tp1.dto.CalculationDTO;
import infnet.spring.boot.tp1.entity.Calculation;
import infnet.spring.boot.tp1.service.CalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping
    public List<Calculation> findAll() {
        return calculationService.findAllCalculations(null);
    }

    @GetMapping("/soma")
    public List<Calculation> findAllAdditions() {
        return calculationService.findAllCalculations("Adição");
    }

    @PostMapping("/soma")
    public Calculation addition(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.addition());
    }

    @GetMapping("/subtracao")
    public List<Calculation> findAllSubtractions() {
        return calculationService.findAllCalculations("Subtração");
    }

    @PostMapping("/subtracao")
    public Calculation subtract(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.subtract());
    }

    @GetMapping("/multiplicacao")
    public List<Calculation> findAllMultiplications() {
        return calculationService.findAllCalculations("Multiplicação");
    }

    @PostMapping("/multiplicacao")
    public Calculation multiply(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.multiply());
    }

    @GetMapping("/divisao")
    public List<Calculation> findAllDivisions() {
        return calculationService.findAllCalculations("Divisão");
    }

    @PostMapping("/divisao")
    public Calculation division(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.division());
    }

    @GetMapping("/exponenciacao")
    public List<Calculation> findAllExponentiation() {
        return calculationService.findAllCalculations("Exponenciação");
    }

    @PostMapping("/exponenciacao")
    public Calculation exponentiation(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.exponentiation());
    }

}
