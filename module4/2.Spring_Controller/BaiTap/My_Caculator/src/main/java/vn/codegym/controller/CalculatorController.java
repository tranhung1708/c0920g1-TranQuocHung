package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.CalculatorService;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("")
    public String getHome() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam Integer num1, @RequestParam Integer num2, @RequestParam String operator, Model model) throws ArithmeticException {
        try {
            model.addAttribute("num1", num1);
            model.addAttribute("num2", num2);
            model.addAttribute("operator", operator);
            model.addAttribute("result", calculatorService.calculating(num1, num2, operator));

        } catch (ArithmeticException e) {
            String error = e.getMessage();
            model.addAttribute("result",error);
        }
        return "result";
    }
}