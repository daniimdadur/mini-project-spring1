package com.bootcamp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

  @GetMapping("/index")
    public ModelAndView home(){
        return new ModelAndView("pages/home/index");
    }
}
