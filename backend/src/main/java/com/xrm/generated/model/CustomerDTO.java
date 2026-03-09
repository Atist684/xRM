package com.xrm.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xrm.generated.model.ClassificationDTO;
import com.xrm.generated.model.CustomerStatusDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CustomerDTO
 */

@JsonTypeName("customerDTO")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-09T19:31:32.650574400+01:00[Europe/Budapest]", comments = "Generator version: 7.7.0")
public class CustomerDTO {

  private BigDecimal id;

  private String name;

  private String taxNumber;

  private String address;

  @Valid
  private List<ClassificationDTO> classification = new ArrayList<>();

  private CustomerStatusDTO status;

  public CustomerDTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public CustomerDTO name(String name) {
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

  public CustomerDTO taxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
    return this;
  }

  /**
   * Get taxNumber
   * @return taxNumber
   */
  
  @Schema(name = "taxNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taxNumber")
  public String getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  public CustomerDTO address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   */
  
  @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CustomerDTO classification(List<ClassificationDTO> classification) {
    this.classification = classification;
    return this;
  }

  public CustomerDTO addClassificationItem(ClassificationDTO classificationItem) {
    if (this.classification == null) {
      this.classification = new ArrayList<>();
    }
    this.classification.add(classificationItem);
    return this;
  }

  /**
   * Get classification
   * @return classification
   */
  @Valid 
  @Schema(name = "classification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("classification")
  public List<ClassificationDTO> getClassification() {
    return classification;
  }

  public void setClassification(List<ClassificationDTO> classification) {
    this.classification = classification;
  }

  public CustomerDTO status(CustomerStatusDTO status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public CustomerStatusDTO getStatus() {
    return status;
  }

  public void setStatus(CustomerStatusDTO status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customerDTO = (CustomerDTO) o;
    return Objects.equals(this.id, customerDTO.id) &&
        Objects.equals(this.name, customerDTO.name) &&
        Objects.equals(this.taxNumber, customerDTO.taxNumber) &&
        Objects.equals(this.address, customerDTO.address) &&
        Objects.equals(this.classification, customerDTO.classification) &&
        Objects.equals(this.status, customerDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, taxNumber, address, classification, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    taxNumber: ").append(toIndentedString(taxNumber)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

