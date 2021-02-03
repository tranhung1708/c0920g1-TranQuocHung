package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Cart;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpUserForm() {
        Cart cart = new Cart();
        return cart;
    }

    @GetMapping("/")
    public ModelAndView listProduct(){
       return new ModelAndView("listProduct", "product" , productService.finAll());
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") int id){
        System.out.println(productService.finById(id).getId_product());
        return new ModelAndView("viewProduct","product",productService.finById(id));
    }

    @PostMapping("/view-product/{id}")
    public ModelAndView addViewProduct(@PathVariable("id") int id,@ModelAttribute("cart") Cart cart){
        Product product=productService.finById(id);
        ModelAndView modelAndView=new ModelAndView("viewProduct");
        modelAndView.addObject("product",product);
        if (product==null){
            modelAndView.addObject("message","Error");
        }else{
            cart.addToCart(product);
            modelAndView.addObject("message","Add "+product.getName_product()+" to cart successfully\nAmount: "+cart.getAmount(product));
        }
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView goToCart(@ModelAttribute("cart") Cart cart){
        return new ModelAndView("cart","list",cart.getCart());
    }
    @GetMapping("/cart/{id}")
    public ModelAndView removeProduct(@ModelAttribute("cart") Cart cart,@PathVariable("id") int id){
        cart.removeProduct(productService.finById(id));
        return new ModelAndView("redirect:/cart");
    }
}
