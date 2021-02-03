package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;
import vn.codegym.service.ProductServiceImpl;

import java.util.List;

@Controller
public class ProductManager {
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        List<Product> productList = productService.finAll();
        model.addAttribute("product", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(Product product) {
        product.setIdProduct((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.finById(id));
        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(Product product) {
        productService.update(product.getIdProduct(), product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.finById(id));
        return "/delete";
    }

    @PostMapping("/product/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getIdProduct());
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.finById(id));
        return "/view";
    }
}
