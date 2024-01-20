package com.waa.lab2.controller;

import com.waa.lab2.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    @GetMapping("/:id")
    public UserDto getUser(@PathVariable String id){

        return new UserDto();

    }


}
