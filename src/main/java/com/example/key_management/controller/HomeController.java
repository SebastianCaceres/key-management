package com.example.key_management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "serial") String serial, Model model){
        model.addAttribute("serial",serial);

        return "edit";
    }




}
