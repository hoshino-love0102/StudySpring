package javastudy20250724.controller;

import javastudy20250724.dto.ArticleForm;
import javastudy20250724.entity.Article;
import javastudy20250724.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Article article = form.toEntity();
        System.out.println(article.toString());
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "redirect:/input";
    }

    @GetMapping("/article/{id}")
    public String showArticle(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null) {
            return "error"; // 예외 처리 또는 에러 페이지
        }
        model.addAttribute("article", article);
        return "article"; // article.html 뷰에서 데이터 출력
    }
}
