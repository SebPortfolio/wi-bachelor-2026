package de.htwberlin.wi.codefirst.article;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleApiController implements ArticleApi {

        private final ArticleService articleService;
        private final ArticleMapper articleMapper;

        @Override
        public ResponseEntity<List<ArticleWdto>> getAllArticles() {
                List<Article> articles = this.articleService.getAllArticles();

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
