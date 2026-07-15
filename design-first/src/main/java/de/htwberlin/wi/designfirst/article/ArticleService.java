package de.htwberlin.wi.designfirst.article;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.htwberlin.wi.designfirst.article.articlecategory.ArticleCategory;
import jakarta.annotation.PostConstruct;

@Service
public class ArticleService {

        private List<Article> allArticles = new LinkedList<>();

        @PostConstruct
        public void initTestData() {
                allArticles.add(Article.builder()
                                .id(0L)
                                .name("Bio-Apfel")
                                .category(ArticleCategory.OBST)
                                .price(new BigDecimal("2.99"))
                                .createdAt(OffsetDateTime.of(2026, 7, 1, 13, 34, 12, 56, ZoneOffset.ofHours(2)))
                                .lastEditedAt(OffsetDateTime.of(2026, 7, 12, 20, 6, 25, 410, ZoneOffset.ofHours(2)))
                                .build());
                allArticles.add(Article.builder()
                                .id(1L)
                                .name("Mineralwasser")
                                .category(ArticleCategory.GETRAENK)
                                .description("1l, Glas-Flasche")
                                .price(new BigDecimal("0.99"))
                                .createdAt(OffsetDateTime.of(2026, 7, 5, 1, 3, 52, 546, ZoneOffset.ofHours(2)))
                                .lastEditedAt(OffsetDateTime.of(2026, 7, 6, 13, 35, 36, 66, ZoneOffset.ofHours(2)))
                                .build());
                allArticles.add(Article.builder()
                                .id(2L)
                                .name("Vollmilchschokoladentafel")
                                .category(ArticleCategory.SCHOKOLADE)
                                .price(new BigDecimal("1.89"))
                                .createdAt(OffsetDateTime.of(2026, 7, 8, 7, 21, 12, 2, ZoneOffset.ofHours(2)))
                                .build());
                allArticles.add(Article.builder()
                                .id(3L)
                                .name("Mini-Cherryrispentomaten")
                                .description("300g, aus Sachen-Anhalt")
                                .category(ArticleCategory.GEMUESE)
                                .price(new BigDecimal("2.79"))
                                .createdAt(OffsetDateTime.of(2026, 7, 12, 9, 36, 12, 56, ZoneOffset.ofHours(2)))
                                .lastEditedAt(OffsetDateTime.of(2026, 7, 17, 15, 51, 8, 63, ZoneOffset.ofHours(2)))
                                .build());
                allArticles.add(Article.builder()
                                .id(4L)
                                .name("Orangensaft")
                                .category(ArticleCategory.GETRAENK)
                                .description("0,75, PET-Flasche")
                                .price(new BigDecimal("1.65"))
                                .createdAt(OffsetDateTime.of(2026, 7, 15, 6, 9, 7, 710, ZoneOffset.ofHours(2)))
                                .build());
        }

        public List<Article> getAllArticles() {
                return this.allArticles;
        }

        public List<Article> getArticlesFilteredByCategory(ArticleCategory category) {
                return this.allArticles
                                .stream().filter(article -> article.getCategory().equals(category))
                                .collect(Collectors.toList());
        }

        public Article getArticleById(Long id) {
                return this.allArticles.stream()
                                .filter(article -> article.getId().equals(id))
                                .findFirst()
                                .orElse(null);
        }
}
