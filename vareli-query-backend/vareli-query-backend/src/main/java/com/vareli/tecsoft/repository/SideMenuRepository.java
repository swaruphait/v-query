package com.vareli.tecsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vareli.tecsoft.model.SideMenuOption;

public interface SideMenuRepository extends JpaRepository<SideMenuOption, Integer>{
    
}
