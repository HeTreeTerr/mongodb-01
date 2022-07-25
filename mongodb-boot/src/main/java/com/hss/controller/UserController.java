package com.hss.controller;

import com.hss.dto.CreateUserDTO;
import com.hss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(String name){

        CreateUserDTO userDTO = CreateUserDTO.builder()
                .name(name)
                .age(18)
                .tags(Arrays.asList("A","B","C"))
                .build();
        userService.createUser(userDTO);
        return "test";
    }
}
