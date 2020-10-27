package com.ahsel.simbirsoft.controllers;
import com.ahsel.simbirsoft.parser.DownloaderHtmlPage;
import com.ahsel.simbirsoft.repo.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorController {
    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping("/error")
    public String home(Model model) {
        DownloaderHtmlPage downloader = new DownloaderHtmlPage();
        return "error";
    }


}
