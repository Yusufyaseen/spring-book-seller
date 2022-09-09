package com.store.springbootbookstore.controllers;

import com.store.springbootbookstore.model.Role;
import com.store.springbootbookstore.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("all")
public class Control {


    @GetMapping("/5")
    public String toString() {
        return Role.USER.name();
    }
}
