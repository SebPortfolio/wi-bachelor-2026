package de.htwberlin.wi.codefirst.article;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    @Mapping(source = "price", target = "price.amount")
    @Mapping(target = "price.currency", constant = "EUR")
    ArticleWdto toWdto(Article article);

    @Mapping(source = "price.amount", target = "price")
    Article fromWdto(ArticleWdto articleWdto);

    List<ArticleWdto> toWdtoList(List<Article> articles);

    List<Article> fromWdtoList(List<ArticleWdto> articleWdtos);
}
