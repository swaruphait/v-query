package com.vareli.tecsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vareli.tecsoft.model.SideMenuOption;
import com.vareli.tecsoft.service.SideMenuService;

@RestController
@RequestMapping("/api/side-menu")
public class SideMenuController {
    
    @Autowired
    private SideMenuService sideMenuService;

    @PostMapping("/addSideMenu")
    public ResponseEntity<?> addSideMenu(@ModelAttribute SideMenuOption sideMenuOption) {
        return sideMenuService.addSideMenu(sideMenuOption);
    }

}
