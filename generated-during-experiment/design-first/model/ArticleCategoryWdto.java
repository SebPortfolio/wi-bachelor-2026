package de.htwberlin.wi.designfirst.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Zur Klassifizierung der Artikelgruppen.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-13T16:23:59.363144200+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public enum ArticleCategoryWdto implements Serializable {
  
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

