package study20250723.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_01 {
    @GetMapping("/abcd")
    public String method01(Model model) {
        model.addAttribute("username", "admin");
        return "hi";
    }
}
