package de.htwberlin.wi.codefirst.article.money;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.io.Serializable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Geld-Objekt zur Repräsentation eines Preises in verschiedenen Währungen.
 */
@Data
@Schema(name = "Money", description = "Geld-Objekt zur Repräsentation eines Preises in verschiedenen Währungen.")
@JsonTypeName("Money")
public class MoneyWdto implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private BigDecimal amount;

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
    private String currency;
}
