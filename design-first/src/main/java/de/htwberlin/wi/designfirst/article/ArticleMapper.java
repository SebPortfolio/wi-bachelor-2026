package de.htwberlin.wi.designfirst.article;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import de.htwberlin.wi.designfirst.article.articlecategory.ArticleCategoryMapper;
import de.htwberlin.wi.designfirst.model.ArticleWdto;

@Mapper(componentModel = "spring", uses = { ArticleCategoryMapper.class })
public interface ArticleMapper {
    @Mapping(target = "price.amount", source = "price")
    @Mapping(target = "price.currency", constant = "EUR")
    ArticleWdto toWdto(Article article);

    @Mapping(target = "price", source = "price.amount")
    Article fromWdto(ArticleWdto articleWdto);

    List<ArticleWdto> toWdtoList(List<Article> articles);

    List<Article> fromWdtoList(List<ArticleWdto> articleWdtos);
}
