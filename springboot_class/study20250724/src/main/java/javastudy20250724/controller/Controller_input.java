package javastudy20250724.controller;

import javastudy20250724.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controller_input {

    @GetMapping("/input")
    public String showFormPage() {
        return "input";
    }

    @PostMapping("/create")
    public String handleCreateForm(ArticleForm form) {
        System.out.println(form.toString());

        return "redirect:/input";
    }
}
