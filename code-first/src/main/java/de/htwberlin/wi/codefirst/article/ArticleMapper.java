package de.htwberlin.wi.codefirst.article;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleWdto toWdto(Article article);

    Article fromWdto(ArticleWdto articleWdto);

    List<ArticleWdto> toWdtoList(List<Article> articles);

    List<Article> fromWdtoList(List<ArticleWdto> articleWdtos);
}
