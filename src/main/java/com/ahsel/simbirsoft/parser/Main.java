package com.ahsel.simbirsoft.parser;

public class Main {
    public static void main(String[] args) {
        DownloaderHtmlPage loader = new DownloaderHtmlPage();
        CleanerHtmlTags cleaenr = new CleanerHtmlTags();
        loader.downloadPage("https://ru.wikipedia.org/wiki/Заглавная_страница");
        cleaenr.cleanTags("https://ru.wikipedia.org/wiki/Заглавная_страница");
        System.out.println("Слова и их количество на: https://ru.wikipedia.org/wiki/Заглавная_страница");
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWord();
    }
}
