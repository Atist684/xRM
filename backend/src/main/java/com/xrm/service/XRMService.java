package com.xrm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xrm.entity.AppUser;
import com.xrm.entity.Customer;
import com.xrm.entity.CustomerStatusEnum;
import com.xrm.entity.Task;
import com.xrm.entity.TaskType;
import com.xrm.generated.model.CustomerDTO;
import com.xrm.generated.model.ResponsibleDTO;
import com.xrm.generated.model.TaskDTO;
import com.xrm.generated.model.TaskDetailsDTO;
import com.xrm.repository.CustomerRepo;
import com.xrm.repository.TaskRepo;
import com.xrm.repository.TaskTypeRepo;
import com.xrm.repository.AppUserRepo;
import com.xrm.utils.DtoEntityMapper;

import jakarta.transaction.Transactional;

@Service
public class XRMService {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AppUserRepo userRepo;

    @Autowired
    TaskTypeRepo taskTypeRepo;

    public void addNewCustomer(CustomerDTO customerDTO) throws Exception {
        if(customerDTO == null){
            throw new NullPointerException("customerDto is null");
        }
        Customer customer = DtoEntityMapper.toCustomerEntity(customerDTO);
        this.customerRepo.save(customer);
    }

    public void deleteCustomer(Integer id) throws Exception {
        if(id == null){
            throw new NullPointerException("id is null");
        }
        Optional<Customer> customer = this.customerRepo.findById(Long.valueOf(id));
        if (customer.isPresent()) {
            this.customerRepo.delete(customer.get());
        } else {
            throw new Exception("User missing");
        }
    }

    public void updateCustomer(CustomerDTO customerDTO) throws Exception {
        if(customerDTO == null){
            throw new NullPointerException("customerDto is null");
        }
        Customer customer = DtoEntityMapper.toCustomerEntity(customerDTO);
        if(customer == null){
            throw new NullPointerException("customer is null");
        }
        this.customerRepo.save(customer);
    }

    public List<CustomerDTO> getCustomers() throws Exception {
        return this.customerRepo.findAll(Sort.by("id")).stream().map(customer -> DtoEntityMapper.toCustomerDto(customer)).toList();
    }

    public List<TaskDTO> getAllTask() throws Exception {
        return taskRepo.findAll(Sort.by("id")).stream().map(task -> DtoEntityMapper.toTaskDto(task)).toList();
    }

    public List<ResponsibleDTO> getAllResponsibleDTOs() throws Exception {
        return userRepo.findAll(Sort.by("id")).stream().map(user -> DtoEntityMapper.toResponsibleDto(user)).toList();
    }

    @Transactional
    public void addNewTask(TaskDTO taskDTO) throws Exception {
        if(taskDTO == null){
            throw new NullPointerException("taskDTO is null");
        }
        TaskType taskType = taskTypeRepo.findByType(taskDTO.getType()).orElseGet(() -> {
            TaskType newType = new TaskType();
            newType.setType(taskDTO.getType());
            return taskTypeRepo.save(newType);
        });
        if (taskType != null) {
            Task task = DtoEntityMapper.toTaskEntity(taskDTO, taskType);
            this.taskRepo.save(task);
        }
    }
    
    @Transactional
    public void updateTask(TaskDTO taskDTO) throws Exception {
    if (taskDTO == null) {
        throw new NullPointerException("taskDTO is null");
    }

    TaskType taskType = taskTypeRepo.findByType(taskDTO.getType())
            .orElseGet(() -> {
                TaskType newType = new TaskType();
                newType.setType(taskDTO.getType());
                return taskTypeRepo.save(newType);
            });
    Task task = taskRepo.findById(taskDTO.getId().longValue())
            .orElseThrow(() -> new RuntimeException("Task not found"));

    Customer customer = customerRepo.findById(taskDTO.getPartner().getId().longValue())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    if (customer.getStatus() == CustomerStatusEnum.Inactive) {
        throw new RuntimeException("Cannot assign Task to inactive Customer");
    }

    AppUser user = userRepo.findById(taskDTO.getResponsible().getId().longValue())
            .orElseThrow(() -> new RuntimeException("User not found"));

    DtoEntityMapper.updateTaskFromDTO(taskDTO, task, taskType, user, customer);

    taskRepo.save(task);
    }
    

    public void deleteTask(Integer id) throws Exception {
        if(id == null){
            throw new NullPointerException("id is null");
        }        
        Optional<Task> task = this.taskRepo.findById(Long.valueOf(id));
        if (task.isPresent()) {
            this.taskRepo.delete(task.get());
        } else {
            throw new Exception("Task missing");
        }
    }

    public List<TaskDetailsDTO> getTasksByCustomerId(Integer id){
        List<TaskDetailsDTO> dto = new ArrayList<>();

        return dto;

    }

}
