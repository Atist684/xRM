package com.xrm.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ReportDTO
 */

@JsonTypeName("reportDTO")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-09T19:31:32.650574400+01:00[Europe/Budapest]", comments = "Generator version: 7.7.0")
public class ReportDTO {

  private String name;

  private Long time;

  private Long partners;

  public ReportDTO name(String name) {
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

  public ReportDTO time(Long time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   */
  
  @Schema(name = "time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public Long getTime() {
    return time;
  }

  public void setTime(Long time) {
    this.time = time;
  }

  public ReportDTO partners(Long partners) {
    this.partners = partners;
    return this;
  }

  /**
   * Get partners
   * @return partners
   */
  
  @Schema(name = "partners", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("partners")
  public Long getPartners() {
    return partners;
  }

  public void setPartners(Long partners) {
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
    ReportDTO reportDTO = (ReportDTO) o;
    return Objects.equals(this.name, reportDTO.name) &&
        Objects.equals(this.time, reportDTO.time) &&
        Objects.equals(this.partners, reportDTO.partners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, time, partners);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportDTO {\n");
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

