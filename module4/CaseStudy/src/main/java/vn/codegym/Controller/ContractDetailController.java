package vn.codegym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.Model.AttachService;
import vn.codegym.Model.ContractDetail;
import vn.codegym.Service.AttachServiceService;
import vn.codegym.Service.ContractDetailService;
import vn.codegym.Service.ContractService;

import java.util.Optional;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;
    @GetMapping("/contractDetailList")
    public String listContractDetail(Model model, @RequestParam Optional<String> nameSearch, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfterSearch = "";
        if (!nameSearch.isPresent()) {
            model.addAttribute("contractDetailList", this.contractDetailService.findAll(pageable));
        } else {
            nameSearchAfterSearch = nameSearch.get();
            model.addAttribute("contractDetailList", this.contractDetailService.findAllByContractDetailId(pageable, nameSearchAfterSearch));
        }
        model.addAttribute("nameSearchAfterSearch", nameSearchAfterSearch);
        return "/contractDetail/list";
    }

    @GetMapping("/createContractDetail")
    public String createContractDetail(Model model) {
        model.addAttribute("contractDetailList", new ContractDetail());
        model.addAttribute("contract" , contractService.findAll());
        model.addAttribute("attachService" , attachServiceService.findAll());
        return "/contractDetail/create";
    }

    @PostMapping("/saveContractDetail")
    public String saveContractDetail(ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "redirect:/contractDetail/contractDetailList";
    }
}
