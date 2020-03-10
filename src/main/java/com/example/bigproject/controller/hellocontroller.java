package com.example.bigproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class hellocontroller {

    @RequestMapping("/hello")
    public String hello(Model model) {
        // model.addAttribute("name", "thymeleaf");
        return "user";
    }

    @RequestMapping("/ziyuanguanli")
    public String hello2(Model model) {
        return "ziyuanguanli";
    }
}
