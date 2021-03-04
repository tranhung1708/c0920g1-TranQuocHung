package com.example.testmodule6.controller;

import com.example.testmodule6.Repository.CustomerRepository;
import com.example.testmodule6.Service.CustomerService;
import com.example.testmodule6.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("customer")
    public List<Customer> getCustomer() {
        return this.customerRepository.findAll();
    }

    @GetMapping(value = {"", "listCustomer"})
    public String listCustomer(Model model) {
        model.addAttribute("customerList", this.customerService.findAll());
        return "index.html";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerList", this.customerService.findAll());
        return "create.html";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Save Ok");
        return "redirect:/listCustomer";
    }
}
