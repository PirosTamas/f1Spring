package com.tomisoft.f1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("save")
    public String save() {
        return "save";
    }

    @GetMapping("list")
    public String list() {
        return "list";
    }
}
