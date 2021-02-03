package vn.codegym.controller;

import com.sun.javafx.collections.ImmutableObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.ServiceService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;

    @GetMapping({"", "/listCustomer"})
    public String listCustomer(Model model, @RequestParam Optional<String> nameCustomer, @RequestParam Optional<String> nameService, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        String nameSearchService = "";
        if (!nameCustomer.isPresent()) {
            model.addAttribute("customerList", this.customerService.findAll(pageable));
        } else if (!nameService.isPresent()) {
            model.addAttribute("customerList", this.customerService.findAll(pageable));
        } else {
            nameSearchAfterSearch = nameCustomer.get();
            nameSearchService = nameService.get();
            Page<Customer> page = new PageImpl<>(this.customerService.search(nameCustomer.orElse(null), nameService.orElse(null)), pageable, 5l);
            model.addAttribute("customerList", page);
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        model.addAttribute("nameSearchService", nameSearchService);
        return "list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("service" , this.serviceService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "create";
        } else {
            customerService.save(customer);
            return "redirect:/listCustomer";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/updateCustomer")
    public String update(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "edit";
        } else {
            customerService.save(customer);
            return "redirect:/listCustomer";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        this.customerService.delete(id);
        return "redirect:/listCustomer";
    }
}
