package com.vareli.tecsoft.service;

import org.springframework.http.ResponseEntity;

import com.vareli.tecsoft.model.SideMenuOption;

public interface SideMenuService {

    ResponseEntity<?> addSideMenu(SideMenuOption sideMenuOption);
    
}
