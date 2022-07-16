package com.example.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path="home")
public class Home implements WebMvcConfigurer {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllHome(ModelMap modelMap){
        return "Home";
    }
}
