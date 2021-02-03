package vn.codegym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.Model.Customer;
import vn.codegym.Model.CustomerType;
import vn.codegym.Service.CustomerService;
import vn.codegym.Service.CustomerTypeService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/home")
    public String home() {
        return "/CaseStudy/caseStudy";
    }

    @GetMapping("/403")
    public String trang403() {
        return "/CaseStudy/4031";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/CaseStudy/formLogin";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "/CaseStudy/formLogin";
    }

    @GetMapping(value = {"", "listCustomer"})
    public String listCustomer(Model model, @RequestParam Optional<String> nameSearch, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        if (!nameSearch.isPresent()) {
            model.addAttribute("customerList", this.customerService.findAll(pageable));
        } else {
            nameSearchAfterSearch = nameSearch.get();
            model.addAttribute("customerList", this.customerService.searchNameAddressGender(pageable, nameSearchAfterSearch));
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("messages" , "Save Oke");
            return "redirect:/customer/listCustomer";
        }
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/updateCustomer")
    public String update(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        this.customerService.delete(id);
        return "redirect:/customer/listCustomer";
    }
}
