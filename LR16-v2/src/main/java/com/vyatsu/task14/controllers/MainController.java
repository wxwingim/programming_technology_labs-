package com.vyatsu.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/main")
public class MainController {
    @GetMapping("/form")
    public String showForm() {
        return "simple-form";
    }

    @GetMapping("/index")
    public String doSomething() {
        return "index";
    }

}
