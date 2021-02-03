package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.CauHoi;
import vn.codegym.service.CauHoiService;
import vn.codegym.service.NguoiDapService;
import vn.codegym.service.NguoiHoiService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CauHoiController {
    @Autowired
    CauHoiService cauHoiService;
    @Autowired
    NguoiDapService nguoiDapService;
    @Autowired
    NguoiHoiService nguoiHoiService;

    @GetMapping({"", "/listCauHoi"})
    public String listCauHoi(Model model, @RequestParam Optional<String> tieuDe, @RequestParam Optional<String> loaiCauHoi, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        String nameSearchService = "";
        if (!tieuDe.isPresent()) {
            model.addAttribute("cauHoiList", this.cauHoiService.findAll(pageable));
        } else if (!loaiCauHoi.isPresent()) {
            model.addAttribute("cauHoiList", this.cauHoiService.findAll(pageable));
        } else {
            nameSearchAfterSearch = tieuDe.get();
            nameSearchService = loaiCauHoi.get();
            Page<CauHoi> page = new PageImpl<>(this.cauHoiService.search(tieuDe.orElse(null), loaiCauHoi.orElse(null)), pageable, 5l);
            model.addAttribute("cauHoiList", page);
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        model.addAttribute("nameSearchService", nameSearchService);
        return "list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("cauHoi", new CauHoi());
        model.addAttribute("nguoiHoi", this.nguoiHoiService.findAll());
        model.addAttribute("nguoiDap", this.nguoiDapService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String saveCauHoi(@Valid @ModelAttribute("cauHoi") CauHoi cauHoi, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cauHoi", cauHoi);
            model.addAttribute("nguoiHoi", this.nguoiHoiService.findAll());
            model.addAttribute("nguoiDap", this.nguoiDapService.findAll());
            return "create";
        } else {
            cauHoiService.save(cauHoi);
            return "redirect:/listCauHoi";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCauHoi(@PathVariable int id, Model model) {

        model.addAttribute("cauHoi", cauHoiService.findById(id));
        model.addAttribute("nguoiHoi", this.nguoiHoiService.findAll());
        model.addAttribute("nguoiDap", this.nguoiDapService.findAll());
        return "edit";
    }

    @PostMapping("/updateCauHoi")
    public String update(@Valid @ModelAttribute("customer") CauHoi cauHoi, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cauHoi", cauHoi);
            model.addAttribute("nguoiHoi", this.nguoiHoiService.findAll());
            model.addAttribute("nguoiDap", this.nguoiDapService.findAll());
            return "edit";
        } else {
            cauHoiService.save(cauHoi);
            return "redirect:/listCauHoi";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        this.cauHoiService.delete(id);
        return "redirect:/listCauHoi";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id ,Model model){
       model.addAttribute("cauHoi" , cauHoiService.findById(id));
        return "/view";
    }
}
