package com.xrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xrm.entity.TaskType;

@Repository
public interface TaskTypeRepo extends JpaRepository<TaskType,Long>{

    Optional<TaskType> findByType(String type); 
    
}
