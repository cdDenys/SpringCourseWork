package com.example.news.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {

    @GetMapping("/homepage")
    public String homepage(Model model) {
        model.addAttribute("title", "Головна сторінка");
        return "homepage";
    }
    @GetMapping("/aboutpage")
    public String main(Model model) {
        model.addAttribute("title", "Про нас");
        return "aboutpage";
    }



}