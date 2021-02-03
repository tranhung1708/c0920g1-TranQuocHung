package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.Calculate;

@Controller
public class CurrencyConversion {
    @Autowired
    private Calculate calculate;
    @GetMapping("/")
    public String currencyConversion() {
        return "/currency";
    }
    @PostMapping("/convert")
    //PostMapping đường dẫn phải giống với action của form
    public String convert(@RequestParam String usd , Model model){
        model.addAttribute("usd",  this.calculate.calculate(Long.parseLong(usd)) );
        return"/currency";
    }
}
