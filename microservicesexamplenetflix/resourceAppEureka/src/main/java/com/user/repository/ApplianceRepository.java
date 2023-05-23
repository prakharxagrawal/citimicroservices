package com.user.repository;

import com.user.model.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

import java.awt.print.Pageable;


public interface ApplianceRepository extends JpaRepository<ApplianceEntity,Integer>{

    @Query("SELECT details FROM ApplianceEntity details WHERE details.brand=?1")
    List<ApplianceEntity> findByApplianceName(String name);
    
}
