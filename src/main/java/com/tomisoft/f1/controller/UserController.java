package com.tomisoft.f1.controller;

import com.tomisoft.f1.dto.UserinfoDTO;
import com.tomisoft.f1.enity.Driver;
import com.tomisoft.f1.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final SecurityService service;

    @GetMapping(value = "userinfo", consumes = MediaType.ALL_VALUE)
    public UserinfoDTO getUserInfo(){
        return this.service.getUserInfo();
    }
}
