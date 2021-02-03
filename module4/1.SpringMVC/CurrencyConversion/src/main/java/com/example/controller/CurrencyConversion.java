package com.example.controller;

import com.example.service.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    private Calculate calculate ;
    @GetMapping("/")
    public String currencyConversion(){
        return "/curency";
    }
 @PostMapping("/covert")
    public String convert (@RequestParam String usd, Model model){
        model.addAttribute("usd" , this.calculate.calculate(Double.parseDouble(usd)));
        return "/curency";
 }
}
