package infnet.spring.boot.tp1.controller;

import infnet.spring.boot.tp1.dto.CalculationChangeDTO;
import infnet.spring.boot.tp1.dto.CalculationDTO;
import infnet.spring.boot.tp1.entity.Calculation;
import infnet.spring.boot.tp1.service.CalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Calculation> findAll() {
        return calculationService.findAllCalculations(null);
    }

    @GetMapping("/soma")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculation> findAllAdditions() {
        return calculationService.findAllCalculations("Adição");
    }

    @PostMapping("/soma")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculation addition(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.addition());
    }

    @GetMapping("/subtracao")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculation> findAllSubtractions() {
        return calculationService.findAllCalculations("Subtração");
    }

    @PostMapping("/subtracao")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculation subtract(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.subtract());
    }

    @GetMapping("/multiplicacao")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculation> findAllMultiplications() {
        return calculationService.findAllCalculations("Multiplicação");
    }

    @PostMapping("/multiplicacao")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculation multiply(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.multiply());
    }

    @GetMapping("/divisao")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculation> findAllDivisions() {
        return calculationService.findAllCalculations("Divisão");
    }

    @PostMapping("/divisao")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculation division(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.division());
    }

    @GetMapping("/exponenciacao")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculation> findAllExponentiation() {
        return calculationService.findAllCalculations("Exponenciação");
    }

    @PostMapping("/exponenciacao")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculation exponentiation(@Valid @RequestBody CalculationDTO calculationDTO) {
        return calculationService.calculate(calculationDTO.exponentiation());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculation update(@PathVariable Long id, @Valid @RequestBody CalculationChangeDTO calculationChangeDTO) {
        return calculationService.changeCalculate(id, calculationChangeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        calculationService.deleteCalculation(id);
    }

}
