package com.ahsel.simbirsoft.controllers;

import com.ahsel.simbirsoft.models.Words;
import com.ahsel.simbirsoft.parser.CleanerHtmlTags;
import com.ahsel.simbirsoft.parser.DownloaderHtmlPage;
import com.ahsel.simbirsoft.parser.WordCounter;
import com.ahsel.simbirsoft.repo.WordsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.Map;

@Controller
public class CounterController {
    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);

    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping(path = "/counter")
    public String count(Model model) {


        return "counter";
    }

    @PostMapping(path = "/counter")
    public String count(@RequestParam String url, Model model) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(url);
        DownloaderHtmlPage loader = new DownloaderHtmlPage();
        CleanerHtmlTags cleaner = new CleanerHtmlTags();
        loader.downloadPage(url);
        cleaner.cleanTags(url);
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWord();
        wordsRepository.deleteAll();
        HashMap<String, Integer> wordMap = wordCounter.getWordMap();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            Words words = new Words(entry.getKey(), entry.getValue());
            wordsRepository.save(words);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        Iterable<Words> words = wordsRepository.findAll();
        model.addAttribute("words", words);
        model.addAttribute("url",url);
        logger.info("Counted words for url {}", url);
        return "counter";
    }
}

