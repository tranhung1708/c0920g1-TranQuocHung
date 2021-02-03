package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import vn.codegym.model.Library;
import vn.codegym.model.OrderBook;
import vn.codegym.service.LibraryService;
import vn.codegym.service.OrderBookService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @Autowired
    OrderBookService orderBookService;

    @GetMapping
    public String showList(Model model, @CookieValue(value = "view", defaultValue = "0") Long count,
                           HttpServletRequest request, HttpServletResponse response){
        count++;
        request.getSession().setAttribute("count", count);
        Cookie cookie = new Cookie("view", count.toString());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        model.addAttribute("libraryList", libraryService.findAll());
        return "list";
    }

    @GetMapping("borrow/{id}")
    public String viewBorrowBook(@PathVariable int id, Model model){
        if(orderBookService.findById(orderBookService.createId()) != null){
            return "redirect:/borrow/{id}";
        }else {
            model.addAttribute("orderBook", new OrderBook(orderBookService.createId(), libraryService.findById(id)));
            return "viewBorrow";
        }
    }

    @GetMapping("save")
    public String save(@ModelAttribute OrderBook orderBook){
        Library library = libraryService.findById(orderBook.getLibrary().getId());
        library.setQuantity(library.getQuantity() - 1);
        libraryService.save(library);
        orderBookService.save(orderBook);
        return "redirect:/";
    }

    @GetMapping("return/{id}")
    public String viewReturnBook(@PathVariable int id, Model model){
        model.addAttribute("orderBook", new OrderBook(0, libraryService.findById(id)));
        return "viewReturn";
    }

    @GetMapping("deleteContract")
    public String delete(@Valid @ModelAttribute OrderBook orderBook, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/viewReturn";
        }
        if(orderBookService.isEmpty(orderBook)){
            orderBookService.delete(orderBookService.findById(orderBook.getId()));
            Library library = libraryService.findById(orderBook.getLibrary().getId());
            library.setQuantity(library.getQuantity() + 1);
            libraryService.save(library);
            return "redirect:/";
        }else {
            model.addAttribute("message", "not found");
            return "/viewReturn";
        }
    }
}
