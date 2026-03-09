package com.xrm.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ResponsibleReportDTOInner
 */

@JsonTypeName("responsibleReportDTO_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-09T16:20:55.651031300+01:00[Europe/Budapest]", comments = "Generator version: 7.7.0")
public class ResponsibleReportDTOInner {

  private BigDecimal sum;

  private BigDecimal uniquePartners;

  public ResponsibleReportDTOInner sum(BigDecimal sum) {
    this.sum = sum;
    return this;
  }

  /**
   * Get sum
   * @return sum
   */
  @Valid 
  @Schema(name = "sum", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sum")
  public BigDecimal getSum() {
    return sum;
  }

  public void setSum(BigDecimal sum) {
    this.sum = sum;
  }

  public ResponsibleReportDTOInner uniquePartners(BigDecimal uniquePartners) {
    this.uniquePartners = uniquePartners;
    return this;
  }

  /**
   * Get uniquePartners
   * @return uniquePartners
   */
  @Valid 
  @Schema(name = "uniquePartners", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uniquePartners")
  public BigDecimal getUniquePartners() {
    return uniquePartners;
  }

  public void setUniquePartners(BigDecimal uniquePartners) {
    this.uniquePartners = uniquePartners;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsibleReportDTOInner responsibleReportDTOInner = (ResponsibleReportDTOInner) o;
    return Objects.equals(this.sum, responsibleReportDTOInner.sum) &&
        Objects.equals(this.uniquePartners, responsibleReportDTOInner.uniquePartners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sum, uniquePartners);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsibleReportDTOInner {\n");
    sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
    sb.append("    uniquePartners: ").append(toIndentedString(uniquePartners)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

