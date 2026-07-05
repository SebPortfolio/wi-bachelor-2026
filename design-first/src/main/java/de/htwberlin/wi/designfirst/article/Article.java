package de.htwberlin.wi.designfirst.article;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import de.htwberlin.wi.designfirst.article.articlecategory.ArticleCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Article {
    private Long id;
    private String name;
    private String description;
    private ArticleCategory category;
    private BigDecimal price;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastEditedAt;
}
