package de.htwberlin.wi.codefirst.article.articlecategory;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleCategoryMapper {

    ArticleCategoryWdto toWdto(ArticleCategory category);

    ArticleCategory fromWdto(ArticleCategoryWdto categoryWdto);
}
