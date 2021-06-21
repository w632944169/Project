package com.bionime.controller;


import com.bionime.entity.User;
import com.bionime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ceshicontroller {

    @Autowired
    UserService service;

    @RequestMapping("/")
    public List<User> ceshi(){

        List<User> user=service.find();

//        return "hello  中文测试";
        return user;
    }
}
