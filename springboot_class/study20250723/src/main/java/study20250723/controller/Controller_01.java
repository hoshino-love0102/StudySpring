package study20250723.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_01 {
    @GetMapping("/hi")
    public String method01() {
        return "hi";
    }
}
