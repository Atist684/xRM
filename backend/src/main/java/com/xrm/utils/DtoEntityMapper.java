package com.xrm.utils;

import java.math.BigDecimal;
import java.util.List;

import com.xrm.entity.AppUser;
import com.xrm.entity.ClassificationEnum;
import com.xrm.entity.Customer;
import com.xrm.entity.CustomerStatusEnum;
import com.xrm.entity.Task;
import com.xrm.entity.TaskType;
import com.xrm.generated.model.ClassificationDTO;
import com.xrm.generated.model.CustomerDTO;
import com.xrm.generated.model.CustomerStatusDTO;
import com.xrm.generated.model.ResponsibleDTO;
import com.xrm.generated.model.TaskDTO;
import com.xrm.generated.model.TaskDetailsDTO;
import com.xrm.generated.model.TaskTypeDTO;

public class DtoEntityMapper {

    public static CustomerDTO toCustomerDto(Customer entity) {

        if (entity == null)
            return null;

        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId() != null ? BigDecimal.valueOf(entity.getId()) : null);
        dto.setName(entity.getName());
        dto.setTaxNumber(entity.getTaxNumber());
        dto.setAddress(entity.getAddress());
        dto.setStatus(entity.getStatus() != null ? CustomerStatusDTO.fromValue(entity.getStatus().name()) : null);
        dto.setClassification(entity.getClassification().stream().map(data -> ClassificationDTO.fromValue(data.name())).toList());
        return dto;
    }

    public static Customer toCustomerEntity(CustomerDTO dto) {
        if (dto == null)
            return null;

        Customer entity = new Customer();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setName(dto.getName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.getStatus() != null ? CustomerStatusEnum.valueOf(dto.getStatus().getValue()) : null);

        List<ClassificationEnum> list = dto.getClassification().stream()
                .map(data -> ClassificationEnum.valueOf(data.getValue())).toList();
        entity.setClassification(list);
        return entity;
    }

       public static ResponsibleDTO toResponsibleDto(AppUser entity) {

        if (entity == null)
            return null;
        ResponsibleDTO dto = new ResponsibleDTO();
        dto.setId(entity.getId() != null ? BigDecimal.valueOf(entity.getId()) : null);
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }


    public static TaskType toTaskTypeEntity(TaskTypeDTO dto) {
        if (dto == null)
            return null;
        TaskType entity = new TaskType();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setType(dto.getName());
        return entity;
    }

    public static AppUser toResponsibleEntity(ResponsibleDTO dto) {
        if (dto == null)
            return null;

        AppUser entity = new AppUser();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        return entity;
    }


    public static TaskDTO toTaskDto(Task entity) {

        if (entity == null)
            return null;

        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId() != null ? BigDecimal.valueOf(entity.getId()) : null);
        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setPartner(DtoEntityMapper.toCustomerDto(entity.getCustomer()));
        dto.setType(entity.getTaskType().getType());
        dto.setTime(BigDecimal.valueOf(entity.getTime()));
        dto.setResponsible(DtoEntityMapper.toResponsibleDto(entity.getResponsibleUser()));
        return dto;
    }

        public static TaskDetailsDTO toTaskDetailsDto(Task entity) {

        if (entity == null)
            return null;
        TaskDetailsDTO dto = new TaskDetailsDTO();
        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getTaskType().getType());
        dto.setTime(BigDecimal.valueOf(entity.getTime()));
        return dto;
    }

    public static Task toTaskEntity(TaskDTO dto, TaskType taskType) {

        if (dto == null)
            return null;

        Task entity = new Task();
        
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setSubject(dto.getSubject());
        entity.setDescription(dto.getDescription());
        entity.setCustomer(DtoEntityMapper.toCustomerEntity(dto.getPartner()));
        entity.setTaskType(taskType);
        entity.setTime(dto.getTime() != null ? dto.getTime().longValue() : null);
        entity.setResponsibleUser(DtoEntityMapper.toResponsibleEntity(dto.getResponsible()));

        return entity;
    }

    public static void updateTaskFromDTO(TaskDTO dto, Task task, TaskType taskType, AppUser user, Customer customer) {
        task.setSubject(dto.getSubject());
        task.setDescription(dto.getDescription());
        task.setTime(dto.getTime().longValue());
        task.setResponsibleUser(user);
        task.setCustomer(customer);
        task.setTaskType(taskType);
    }
}
