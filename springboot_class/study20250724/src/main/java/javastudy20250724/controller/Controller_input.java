package javastudy20250724.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller_input {

    @GetMapping("/input")
    public String showFormPage() {
        return "input";
    }

    @PostMapping("/create")
    public String handleCreateForm(@RequestParam String title, @RequestParam String content) {
        System.out.println("전송된 제목: " + title);
        System.out.println("전송된 내용: " + content);

        return "redirect:/input";
    }
}