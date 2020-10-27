package com.ahsel.simbirsoft.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//class counts repeat words in htmlWithoutTags.HTML
public class WordCounter implements Counter {
   private List<String> words;
   private HashMap<String, Integer> wordMap;

    public WordCounter() {
        this.words = makeWordList();
    }

    public HashMap<String, Integer> countWord() {
        wordMap = new HashMap<>();
        toUpperCase();
        for (String word : this.words) {
            if (word.matches("^[A-Z,a-z,а-я,А-Я]+$")) {
                wordMap.put(word, Collections.frequency(words, word));
            }
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return wordMap;
    }

    private List<String> makeWordList() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("downloads/htmlWithoutTags.html"))) {
            String inputString = bufferedReader.readLine();
            words = Arrays.asList(inputString.split("[' ', ',', '.', '!', '?','\"', ';', ':', '[', ']', '(', ')', '\\n', '\\r', '\\t']"));
            words.remove(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    private void toUpperCase() {
        for (int i = 0; i < this.words.size(); i++) {
            this.words.set(i, this.words.get(i).toUpperCase());
        }
    }

    public HashMap<String, Integer> getWordMap() {
        return wordMap;
    }
}
