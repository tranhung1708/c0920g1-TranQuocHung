package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
@Autowired
    CustomerService customerService;
@GetMapping("/list")
    public String listCustomer(Model model){
    model.addAttribute("customer", customerService.findAll());
    return "/customer/list";
}
}
