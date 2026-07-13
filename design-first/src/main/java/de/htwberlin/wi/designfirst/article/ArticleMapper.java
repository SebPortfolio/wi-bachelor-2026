package de.htwberlin.wi.designfirst.article;

import java.util.List;

import org.mapstruct.Mapper;

import de.htwberlin.wi.designfirst.model.ArticleWdto;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleWdto toWdto(Article article);

    Article fromWdto(ArticleWdto articleWdto);

    List<ArticleWdto> toWdtoList(List<Article> articles);

    List<Article> fromWdtoList(List<ArticleWdto> articleWdtos);
}
