package de.htwberlin.wi.codefirst.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import de.htwberlin.wi.codefirst.article.articlecategory.ArticleCategoryWdto;
import de.htwberlin.wi.codefirst.article.money.MoneyWdto;

import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.io.Serializable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(name = "Article", description = "Ein Artikel.")
@JsonTypeName("Article")
public class ArticleWdto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Die eindeutige ID eines Artikels.
     * 
     * @return id
     */
    @NotNull
    @Schema(name = "id", example = "23", description = "Die eindeutige ID eines Artikels.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    private Long id;

    /**
     * Die Bezeichnung eines Artikels.
     * 
     * @return name
     */
    @NotNull
    @Pattern(regexp = "^[a-zäöüßA-ZÄÖÜ0-9 \\-]+$")
    @Size(min = 1, max = 255)
    @Schema(name = "name", example = "Weintrauben dunkel", description = "Die Bezeichnung eines Artikels.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    private String name;

    /**
     * Die Klassifizierung eines Artikels.
     * 
     * @return category
     */
    @NotNull
    @Valid
    @Schema(name = "category", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("category")
    private ArticleCategoryWdto category;

    /**
     * Die Beschreibung eines Artikels.
     * 
     * @return description
     */

    @Schema(name = "description", example = "500g, abgepackt", description = "Die Beschreibung eines Artikels.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("description")
    private @Nullable String description;

    /**
     * Der aktuelle Netto-Preis des Artikels.
     * minimum: 0
     * 
     * @return price
     */
    @NotNull
    @DecimalMin(value = "0")
    @Schema(name = "price", description = "Der aktuelle Netto-Preis des Artikels.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("price")
    private MoneyWdto price;

    /**
     * Zeitpunkt der Artikelerstellung.
     * 
     * @return createdAt
     */
    @NotNull
    @Valid
    @Schema(name = "createdAt", example = "2026-07-02T14:00Z", description = "Zeitpunkt der Artikelerstellung.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("createdAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    /**
     * Zeitpunkt der letzten Bearbeitung.
     * 
     * @return lastEditedAt
     */
    @Valid
    @Schema(name = "lastEditedAt", description = "Zeitpunkt der letzten Bearbeitung.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("lastEditedAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Nullable OffsetDateTime lastEditedAt;
}
