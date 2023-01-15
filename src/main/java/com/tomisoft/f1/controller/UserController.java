package com.tomisoft.f1.controller;

import com.tomisoft.f1.dto.UserinfoDTO;
import com.tomisoft.f1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService service;

    @GetMapping(value = "userinfo", consumes = MediaType.ALL_VALUE)
    public UserinfoDTO getUserInfo(){
        return this.service.getUserInfo();
    }
}
