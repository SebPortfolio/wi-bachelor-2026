package de.htwberlin.wi.codefirst.article.articlecategory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ArticleCategory", description = "Zur Klassifizierung von Artikeln.", example = "OBST")
public enum ArticleCategoryWdto {

    OBST("OBST"),

    GEMUESE("GEMUESE"),

    SCHOKOLADE("SCHOKOLADE"),

    GETRAENK("GETRAENK");

    private final String value;

    ArticleCategoryWdto(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ArticleCategoryWdto fromValue(String value) {
        for (ArticleCategoryWdto b : ArticleCategoryWdto.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
