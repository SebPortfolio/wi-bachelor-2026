package de.htwberlin.wi.designfirst.article.articlecategory;

import org.mapstruct.Mapper;

import de.htwberlin.wi.designfirst.model.ArticleCategoryWdto;

@Mapper(componentModel = "spring")
public interface ArticleCategoryMapper {
    ArticleCategoryWdto toWdto(ArticleCategory category);

    ArticleCategory fromWdto(ArticleCategoryWdto categoryWdto);
}
