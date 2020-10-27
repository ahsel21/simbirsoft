package com.ahsel.simbirsoft.controllers;

import com.ahsel.simbirsoft.models.Words;
import com.ahsel.simbirsoft.repo.WordsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping("/")
    public String home() {
       return "home";
    }


}
