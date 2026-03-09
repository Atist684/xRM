package com.xrm.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xrm.generated.model.ClassificationDTO;
import com.xrm.generated.model.CustomerStatusDTO;
import com.xrm.generated.model.TaskDTO;
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
 * CustomerDetailsDTO
 */

@JsonTypeName("customerDetailsDTO")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-09T19:31:32.650574400+01:00[Europe/Budapest]", comments = "Generator version: 7.7.0")
public class CustomerDetailsDTO {

  private BigDecimal id;

  private String name;

  private String taxNumber;

  private String address;

  @Valid
  private List<ClassificationDTO> classification = new ArrayList<>();

  private CustomerStatusDTO status;

  @Valid
  private List<@Valid TaskDTO> task = new ArrayList<>();

  public CustomerDetailsDTO id(BigDecimal id) {
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

  public CustomerDetailsDTO name(String name) {
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

  public CustomerDetailsDTO taxNumber(String taxNumber) {
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

  public CustomerDetailsDTO address(String address) {
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

  public CustomerDetailsDTO classification(List<ClassificationDTO> classification) {
    this.classification = classification;
    return this;
  }

  public CustomerDetailsDTO addClassificationItem(ClassificationDTO classificationItem) {
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

  public CustomerDetailsDTO status(CustomerStatusDTO status) {
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

  public CustomerDetailsDTO task(List<@Valid TaskDTO> task) {
    this.task = task;
    return this;
  }

  public CustomerDetailsDTO addTaskItem(TaskDTO taskItem) {
    if (this.task == null) {
      this.task = new ArrayList<>();
    }
    this.task.add(taskItem);
    return this;
  }

  /**
   * Get task
   * @return task
   */
  @Valid 
  @Schema(name = "task", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("task")
  public List<@Valid TaskDTO> getTask() {
    return task;
  }

  public void setTask(List<@Valid TaskDTO> task) {
    this.task = task;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDetailsDTO customerDetailsDTO = (CustomerDetailsDTO) o;
    return Objects.equals(this.id, customerDetailsDTO.id) &&
        Objects.equals(this.name, customerDetailsDTO.name) &&
        Objects.equals(this.taxNumber, customerDetailsDTO.taxNumber) &&
        Objects.equals(this.address, customerDetailsDTO.address) &&
        Objects.equals(this.classification, customerDetailsDTO.classification) &&
        Objects.equals(this.status, customerDetailsDTO.status) &&
        Objects.equals(this.task, customerDetailsDTO.task);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, taxNumber, address, classification, status, task);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDetailsDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    taxNumber: ").append(toIndentedString(taxNumber)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
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

