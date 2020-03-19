package com.rodzyn.homework07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menu")
public class MenuController {

    @GetMapping
    public String getMenu(){
        return "menu";
    }
}
