package vn.codegym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.Model.Customer;
import vn.codegym.Model.Employee;
import vn.codegym.Service.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionService positionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    UserService userService;

    @GetMapping({"", "/listEmployee"})
    public String listEmployee(Model model, @RequestParam Optional<String> nameSearch, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        if (!nameSearch.isPresent()) {
            model.addAttribute("listEmployee", this.employeeService.findAll(pageable));
        } else {
            nameSearchAfterSearch = nameSearch.get();
            model.addAttribute("listEmployee", this.employeeService.findAllByEmployeeNameContaining(pageable, nameSearchAfterSearch));
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        return "/employee/list";
    }

    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        model.addAttribute("employeeList", new Employee());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("user", userService.findAll());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employeeList") Employee employee,BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("educationDegree", educationDegreeService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("user", userService.findAll());
            return "/employee/create";
        } else {
            employeeService.save(employee);
            return "redirect:/employee/listEmployee";
        }
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("user", userService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/updateEmployee")
    public String update(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/listEmployee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        this.employeeService.delete(id);
        return "redirect:/employee/listEmployee";
    }
}
