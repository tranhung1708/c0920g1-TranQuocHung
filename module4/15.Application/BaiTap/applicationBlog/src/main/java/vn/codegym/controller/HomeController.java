package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "/customer/Hello";
    }
    @GetMapping("/admin")
    public String admin(){
        return "/customer/admin";
    }
    @GetMapping("/create")
    public String create(){
        return "/customer/create";
    }
}
