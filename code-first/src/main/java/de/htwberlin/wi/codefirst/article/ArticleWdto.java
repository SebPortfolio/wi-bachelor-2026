package de.htwberlin.wi.codefirst.article;

import java.util.Objects;
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
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Article", description = "Ein Artikel.")
@JsonTypeName("Article")
public class ArticleWdto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private ArticleCategoryWdto category;

    private @Nullable String description;

    private MoneyWdto price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Nullable OffsetDateTime lastEditedAt;

    public ArticleWdto() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ArticleWdto(Long id, String name, ArticleCategoryWdto category, MoneyWdto price, OffsetDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.createdAt = createdAt;
    }

    public ArticleWdto id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Die eindeutige ID eines Artikels.
     * 
     * @return id
     */
    @NotNull
    @Schema(name = "id", example = "23", description = "Die eindeutige ID eines Artikels.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public ArticleWdto name(String name) {
        this.name = name;
        return this;
    }

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
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public ArticleWdto category(ArticleCategoryWdto category) {
        this.category = category;
        return this;
    }

    /**
     * Die Klassifizierung eines Artikels.
     * 
     * @return category
     */
    @NotNull
    @Valid
    @Schema(name = "category", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("category")
    public ArticleCategoryWdto getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(ArticleCategoryWdto category) {
        this.category = category;
    }

    public ArticleWdto description(@Nullable String description) {
        this.description = description;
        return this;
    }

    /**
     * Die Beschreibung eines Artikels.
     * 
     * @return description
     */

    @Schema(name = "description", example = "500g, abgepackt", description = "Die Beschreibung eines Artikels.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("description")
    public @Nullable String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public ArticleWdto price(MoneyWdto price) {
        this.price = price;
        return this;
    }

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
    public MoneyWdto getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(MoneyWdto price) {
        this.price = price;
    }

    public ArticleWdto createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Zeitpunkt der Artikelerstellung.
     * 
     * @return createdAt
     */
    @NotNull
    @Valid
    @Schema(name = "createdAt", example = "2026-07-02T14:00Z", description = "Zeitpunkt der Artikelerstellung.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("createdAt")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ArticleWdto lastEditedAt(@Nullable OffsetDateTime lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
        return this;
    }

    /**
     * Zeitpunkt der letzten Bearbeitung.
     * 
     * @return lastEditedAt
     */
    @Valid
    @Schema(name = "lastEditedAt", description = "Zeitpunkt der letzten Bearbeitung.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("lastEditedAt")
    public @Nullable OffsetDateTime getLastEditedAt() {
        return lastEditedAt;
    }

    @JsonProperty("lastEditedAt")
    public void setLastEditedAt(@Nullable OffsetDateTime lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArticleWdto article = (ArticleWdto) o;
        return Objects.equals(this.id, article.id) &&
                Objects.equals(this.name, article.name) &&
                Objects.equals(this.category, article.category) &&
                Objects.equals(this.description, article.description) &&
                Objects.equals(this.price, article.price) &&
                Objects.equals(this.createdAt, article.createdAt) &&
                Objects.equals(this.lastEditedAt, article.lastEditedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, description, price, createdAt, lastEditedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArticleWdto {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    lastEditedAt: ").append(toIndentedString(lastEditedAt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(@Nullable Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
