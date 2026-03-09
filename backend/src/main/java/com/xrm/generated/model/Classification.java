package com.xrm.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets classification
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-08T21:51:10.896201900+01:00[Europe/Budapest]", comments = "Generator version: 7.7.0")
public enum Classification {
  
  ACTIVE("Active"),
  
  FOREIGN("Foreign"),
  
  TOP("TOP"),
  
  EXPORT("Export");

  private String value;

  Classification(String value) {
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
  public static Classification fromValue(String value) {
    for (Classification b : Classification.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

