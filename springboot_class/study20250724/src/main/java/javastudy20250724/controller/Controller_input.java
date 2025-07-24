package javastudy20250724.controller;

import javastudy20250724.dto.ArticleForm;
import javastudy20250724.entity.Article;
import javastudy20250724.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controller_input {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/input")
    public String showFormPage() {
        return "input";
    }

    @PostMapping("/create")
    public String handleCreateForm(ArticleForm form) {
        System.out.println(form.toString());

        // DTO를 Entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        // Repository로 Entity를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "redirect:/input";
    }
}