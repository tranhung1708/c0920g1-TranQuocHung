package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String listCus(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWordAfterSearch = "";
        if (!keyword.isPresent()) {
            model.addAttribute("customerList", this.customerService.findAll(pageable));
        } else {
            keyWordAfterSearch = keyword.get();
            model.addAttribute("customerList", this.customerService.findAllByFirstNameContaining(keyWordAfterSearch, pageable));
        }
        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
        return "list";
}
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer){
        this.customerService.save(customer);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        this.customerService.delete(id);
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable int id){
        model.addAttribute("customer",this.customerService.findById(id));
        return "edit";
    }
}

