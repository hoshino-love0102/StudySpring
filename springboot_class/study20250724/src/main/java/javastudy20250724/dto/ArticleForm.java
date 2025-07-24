package javastudy20250724.dto;

import javastudy20250724.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 모든 필드를 받는 생성자를 자동 생성
@ToString// toString() 메소드를 자동 생성
public class ArticleForm {

    private String title;
    private String content;

    public Article toEntity() {
        Article article = new Article();
        article.setTitle(this.title);
        article.setContent(this.content);
        return article;
    }
}