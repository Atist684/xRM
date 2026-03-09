package com.xrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xrm.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser,Long>{
    
}
