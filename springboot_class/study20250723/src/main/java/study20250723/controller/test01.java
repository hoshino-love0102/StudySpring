package study20250723.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class test01 {

    @GetMapping("/exam01")
    public String method01(Model m) {
        m.addAttribute("nn", "홍길동");
        return "test01";
    }

    @GetMapping("/exam02")
    public String method02(Model model,
                           @RequestParam(name = "num01", required = false, defaultValue = "0") String num01,
                           @RequestParam(name = "num02", required = false, defaultValue = "0") String var02) {
        int sum = Integer.parseInt(num01) + Integer.parseInt(var02);
        model.addAttribute("numValue", sum);
        return "test02";
    }
}

// 클래스란? - 먹이(?) 붕어빵틀
// 객체란? - 붕어빵
// 클래스와 객체 간의 관계는 1대n 관계.
// 클래스가 먼저 존재한다.
// 클래스에서는 객체사용을 할수 있나? 없나?
// 객체에서는 클래스를 사용할수 있나? 없나?
// 클래스(static)