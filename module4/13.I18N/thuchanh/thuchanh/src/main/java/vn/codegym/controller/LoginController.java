package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.Credential;
import vn.codegym.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {

    @GetMapping("/login")
    public String login(@ModelAttribute("credential") Credential credential) {
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential") Credential credential, Model model) {
        User user = new User();
        user.setUserName(credential.getUsername());
        model.addAttribute("user", user);
        return "redirect:dashboard";
    }

}
