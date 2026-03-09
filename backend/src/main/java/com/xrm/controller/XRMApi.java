package com.xrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xrm.controller.exceptions.ApiErrorException;
import com.xrm.generated.api.XRmApi;
import com.xrm.generated.model.CustomerDTO;
import com.xrm.generated.model.ReportDTO;
import com.xrm.generated.model.ResponsibleDTO;
import com.xrm.generated.model.TaskDTO;
import com.xrm.generated.model.TaskDetailsDTO;
import com.xrm.repository.TaskRepo;
import com.xrm.service.XRMService;
import com.xrm.utils.DtoEntityMapper;
import com.xrm.utils.ReportProjection;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class XRMApi implements XRmApi {

    private final TaskRepo taskRepo;

    @Autowired
    XRMService xrmService;

    XRMApi(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
    
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProblemDetail> handleNotFound(Exception ex) {
		ProblemDetail error = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @Override
    public ResponseEntity<Void> newCustomer(@Valid CustomerDTO customerDTO) {
         try {
            xrmService.addNewCustomer(customerDTO);
         } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
         }
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Integer id) {
         try {
            xrmService.deleteCustomer(id);
         } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
         }

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        List<CustomerDTO> list = null;
        try {
            list = this.xrmService.getCustomers();
        } catch (Exception e) {
           throw new ApiErrorException(e.getMessage());
        }
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomer(CustomerDTO customer) {
        
         try {
            xrmService.updateCustomer(customer);
         } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
         }
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<ResponsibleDTO>> getAllResponsibleUser() {
        List<ResponsibleDTO> list = null;
        try {
            list = this.xrmService.getAllResponsibleDTOs();
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<List<TaskDTO>> getAllTask() {

        List<TaskDTO> list = null;
        try {
            list = this.xrmService.getAllTask();
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
        return ResponseEntity.ok(list);
    }


    @Override
    public ResponseEntity<Void> deleteTask(Integer taskId) {
         try {
            xrmService.deleteTask(taskId);
         } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
         }

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> newTask(@Valid TaskDTO taskDTO) {
         try {
            xrmService.addNewTask(taskDTO);
         } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
         }
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<TaskDTO> updateTask(@Valid TaskDTO taskDTO) {
          try {
            xrmService.updateTask(taskDTO);
         } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
         }
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<ReportDTO>> getReport() {

        List<ReportProjection> projection = this.taskRepo.getResponsibleReport();
        List<ReportDTO> list = projection.stream().map(data -> {
            ReportDTO dto = new ReportDTO();
            dto.setName(data.getName());
            dto.setPartners(data.getPartners());
            dto.setTime(data.getTime());
            return dto;
        }).toList();

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<List<TaskDetailsDTO>> getCustomerTasks(Integer customerId) {
        List<TaskDetailsDTO> list = taskRepo.findAllByCustomerId(customerId.longValue()).stream().map(task -> DtoEntityMapper.toTaskDetailsDto(task)).toList();
        return ResponseEntity.ok(list);
    }



}
