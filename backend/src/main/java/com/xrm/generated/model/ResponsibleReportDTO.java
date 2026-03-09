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
 * ResponsibleReportDTO
 */

@JsonTypeName("responsibleReportDTO")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-09T16:23:10.833454500+01:00[Europe/Budapest]", comments = "Generator version: 7.7.0")
public class ResponsibleReportDTO {

  private String name;

  private BigDecimal time;

  private BigDecimal partners;

  public ResponsibleReportDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResponsibleReportDTO time(BigDecimal time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   */
  @Valid 
  @Schema(name = "time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public BigDecimal getTime() {
    return time;
  }

  public void setTime(BigDecimal time) {
    this.time = time;
  }

  public ResponsibleReportDTO partners(BigDecimal partners) {
    this.partners = partners;
    return this;
  }

  /**
   * Get partners
   * @return partners
   */
  @Valid 
  @Schema(name = "partners", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("partners")
  public BigDecimal getPartners() {
    return partners;
  }

  public void setPartners(BigDecimal partners) {
    this.partners = partners;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsibleReportDTO responsibleReportDTO = (ResponsibleReportDTO) o;
    return Objects.equals(this.name, responsibleReportDTO.name) &&
        Objects.equals(this.time, responsibleReportDTO.time) &&
        Objects.equals(this.partners, responsibleReportDTO.partners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, time, partners);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsibleReportDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    partners: ").append(toIndentedString(partners)).append("\n");
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

