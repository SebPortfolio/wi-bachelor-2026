package de.htwberlin.wi.designfirst.article;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.htwberlin.wi.designfirst.article.articlecategory.ArticleCategory;
import jakarta.annotation.PostConstruct;

@Service
public class ArticleService {

    private List<Article> allArticles = new LinkedList<>();

    @PostConstruct
    public void initTestData() {
        allArticles.add(Article.builder()
                .id(1L)
                .name("Bio-Apfel")
                .category(ArticleCategory.OBST)
                .build());
        allArticles.add(Article.builder()
                .id(1L)
                .name("Mineralwasser")
                .category(ArticleCategory.GETRAENK)
                .description("1l, Glas-Flasche")
                .build());
        allArticles.add(Article.builder()
                .id(1L)
                .name("Vollmilchschokoladentafel")
                .category(ArticleCategory.SCHOKOLADE)
                .build());
        allArticles.add(Article.builder()
                .id(1L)
                .name("Mini-Cherryrispentomaten")
                .description("300g, aus Sachen-Anhalt")
                .category(ArticleCategory.GEMUESE)
                .build());
        allArticles.add(Article.builder()
                .id(1L)
                .name("Orangensaft")
                .category(ArticleCategory.GETRAENK)
                .description("0,75, PET-Flasche")
                .build());
    }

    public List<Article> getAllArticles() {
        return this.allArticles;
    }

    public Article getArticleById(Long id) {
        return this.allArticles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
