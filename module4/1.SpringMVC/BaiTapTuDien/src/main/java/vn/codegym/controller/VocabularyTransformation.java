package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.DictionaryService;

@Controller
public class VocabularyTransformation {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String vocabularyTransformation() {
        return "/vocabularyTransformation";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam String searchWord, Model model) {
        String result=dictionaryService.search(searchWord);
        System.out.println(result);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("result",result);
        return "/vocabularyTransformation";
    }
}
