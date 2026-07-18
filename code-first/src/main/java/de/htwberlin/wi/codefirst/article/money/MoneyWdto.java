package de.htwberlin.wi.codefirst.article.money;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import org.springframework.lang.Nullable;
import java.io.Serializable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Geld-Objekt zur Repräsentation eines Preises in verschiedenen Währungen.
 */

@Schema(name = "Money", description = "Geld-Objekt zur Repräsentation eines Preises in verschiedenen Währungen.")
@JsonTypeName("Money")
public class MoneyWdto implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private String currency;

    public MoneyWdto() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public MoneyWdto(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public MoneyWdto amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Der Betrag beschreibt die Haupt- und Untereinheit der Währung in einem
     * einzigen Wert, wobei der ganzzahlige Teil (die Ziffern vor dem Dezimalpunkt)
     * für die Haupteinheit und der Nachkommateil (die Ziffern nach dem
     * Dezimalpunkt) für die Untereinheit steht.
     * minimum: 0.0
     * 
     * @return amount
     */
    @NotNull
    @Valid
    @DecimalMin(value = "0.0")
    @Schema(name = "amount", format = "decimal", example = "1.49", description = "Der Betrag beschreibt die Haupt- und Untereinheit der Währung in einem einzigen Wert, wobei der ganzzahlige Teil (die Ziffern vor dem Dezimalpunkt) für die Haupteinheit und der Nachkommateil (die Ziffern nach dem Dezimalpunkt) für die Untereinheit steht. ", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public MoneyWdto currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Der 3 Zeichen lange Buchstabencode der Währung, wie er durch ISO-4217
     * definiert ist.
     * 
     * @return currency
     */
    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$")
    @Schema(name = "currency", format = "iso-4217", example = "EUR", description = "Der 3 Zeichen lange Buchstabencode der Währung, wie er durch ISO-4217 definiert ist.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoneyWdto money = (MoneyWdto) o;
        return Objects.equals(this.amount, money.amount) &&
                Objects.equals(this.currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MoneyWdto {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
