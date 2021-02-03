package vn.codegym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.Model.Service;
import vn.codegym.Service.RentTypeService;
import vn.codegym.Service.ServiceService;
import vn.codegym.Service.ServiceTypeService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;
    @GetMapping(value = {"", "/listService"})
    public String listService(Model model, @RequestParam Optional<String> nameSearch,
                              @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        if (!nameSearch.isPresent()) {
            model.addAttribute("serviceList", this.serviceService.findAll(pageable));
        } else {
            nameSearchAfterSearch = nameSearch.get();
            model.addAttribute("serviceList", this.serviceService.findAllByCustomer_nameContaining(pageable, nameSearchAfterSearch));
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        return "/service/list";
    }

    @GetMapping("/createService")
    public String createService(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("rentType" , rentTypeService.findAll());
        model.addAttribute("serviceTypeList" , serviceTypeService.findAll());
        return "/service/create";
    }

    @PostMapping("/saveService")
    public String save(@Valid @ModelAttribute Service service , BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("rentType", rentTypeService.findAll());
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            return "/service/create";
        }
        serviceService.save(service);
        return "redirect:/service/listService";
    }

    @GetMapping("/edit/{id}")
    public String editService(@PathVariable String id, Model model) {
        model.addAttribute("service", serviceService.findById(id));
        return "/service/edit";
    }

    @PostMapping("/updateService")
    public String update(@ModelAttribute Service service) {
        serviceService.save(service);
        return "redirect:/service/listService";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        serviceService.delete(id);
        return "redirect:/service/listService";
    }
}
