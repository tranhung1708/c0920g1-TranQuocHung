package com.codegym.blogapplication.controller;

import com.codegym.blogapplication.model.Blog;
import com.codegym.blogapplication.service.BlogApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogApplicationController {
    @Autowired
    BlogApplicationService blogApplicationService;

    @GetMapping("/list")
    public String listBlog(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWordAfterSearch = "studentList";
        if (!keyword.isPresent()) {
            model.addAttribute("blogList", this.blogApplicationService.findAll(pageable));
        } else {
            keyWordAfterSearch = keyword.get();
            model.addAttribute("blogList", this.blogApplicationService.findAllByFirstNameContaining(keyWordAfterSearch, pageable));
        }
        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog){
        this.blogApplicationService.save(blog);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        this.blogApplicationService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable int id){
        model.addAttribute("customer",this.blogApplicationService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogApplicationService.save(blog);
        redirectAttributes.addFlashAttribute("successMsg", "Update blog: " + blog.getContent() + " success!");
        return "redirect:/edit";
    }
}

