package vn.codegym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.Model.Contract;
import vn.codegym.Model.Customer;
import vn.codegym.Service.ContractService;
import vn.codegym.Service.CustomerService;
import vn.codegym.Service.EmployeeService;
import vn.codegym.Service.ServiceService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;

    @GetMapping({"", "/contractList"})
    public String listContract(Model model, @RequestParam Optional<String> nameSearch, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        if (!nameSearch.isPresent()) {
            model.addAttribute("contractList", this.contractService.findAll(pageable));
        } else {
            nameSearchAfterSearch = nameSearch.get();
            model.addAttribute("contractList", this.contractService.findAllByContractIdContaining(pageable, nameSearchAfterSearch));
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String createContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("service", serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("contract") Contract contract,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeService.findAll());
            model.addAttribute("customer", customerService.findAll());
            model.addAttribute("service", serviceService.findAll());
            return "/contract/create";
        } else {
                contractService.save(contract);
            return "redirect:/contract/contractList";
        }
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable String id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("service", serviceService.findAll());
        return "/contract/edit";
    }

    @PostMapping("/updateContract")
    public String update(@ModelAttribute Contract contract) {
        contractService.save(contract);
        return "redirect:/contract/contractList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        this.contractService.delete(id);
        return "redirect:/contract/contractList";
    }
}
