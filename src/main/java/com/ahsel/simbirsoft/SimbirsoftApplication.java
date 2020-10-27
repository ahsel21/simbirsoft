package com.ahsel.simbirsoft;

import com.ahsel.simbirsoft.models.Words;
import com.ahsel.simbirsoft.parser.CleanerHtmlTags;
import com.ahsel.simbirsoft.parser.DownloaderHtmlPage;
import com.ahsel.simbirsoft.parser.WordCounter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimbirsoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimbirsoftApplication.class, args);
    }

}
