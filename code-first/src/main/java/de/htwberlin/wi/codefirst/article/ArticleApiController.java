package de.htwberlin.wi.codefirst.article;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.htwberlin.wi.codefirst.article.articlecategory.ArticleCategory;
import de.htwberlin.wi.codefirst.article.articlecategory.ArticleCategoryMapper;
import de.htwberlin.wi.codefirst.article.articlecategory.ArticleCategoryWdto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleApiController implements ArticleApi {

        private final ArticleService articleService;
        private final ArticleMapper articleMapper;
        private final ArticleCategoryMapper articleCategoryMapper;

        @Override
        public ResponseEntity<List<ArticleWdto>> getAllArticles(ArticleCategoryWdto category) {
                final List<Article> articles;
                if (category == null) {
                        articles = this.articleService.getAllArticles();
                } else {
                        ArticleCategory mappedCategory = this.articleCategoryMapper.fromWdto(category);
                        articles = this.articleService.getArticlesFilteredByCategory(mappedCategory);
                }

                List<ArticleWdto> wdtos = this.articleMapper.toWdtoList(articles);
                return ResponseEntity.ok(wdtos);
        }

        @Override
        public ResponseEntity<ArticleWdto> getArticleById(Long articleId) {
                Article article = this.articleService.getArticleById(articleId);

                if (article == null) {
                        return ResponseEntity.notFound().build();
                }

                ArticleWdto wdto = this.articleMapper.toWdto(article);
                return ResponseEntity.ok(wdto);
        }
}
