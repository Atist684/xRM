package com.xrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xrm.entity.Customer;
import com.xrm.entity.Task;
import com.xrm.utils.ReportProjection;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long>{
    
    List<Task> findAllByCustomer(Customer customer);

    @Query("SELECT t FROM Task t")
    List<Task> findAllWithDeleted();

    @Query(value = """
    SELECT 
        CONCAT(ru.first_name, ' ', ru.last_name) as name,
        SUM(t.time) as time,
        CAST(COUNT(DISTINCT t.customer_id) AS numeric) as partners
    FROM task t
    JOIN app_user ru ON ru.id = t.responsible_user_id
    JOIN customer c ON c.id = t.customer_id
    WHERE t.deleted = false
    AND ru.deleted = false
    AND c.deleted = false
    GROUP BY ru.id, ru.first_name, ru.last_name
    """, nativeQuery = true)
    List<ReportProjection> getResponsibleReport();

    @Query("""
    SELECT t
    FROM Task t
    JOIN t.customer c
    WHERE c.id = :customerId
    """)
    List<Task> findAllByCustomerId(@Param("customerId") Long customerId);

}
