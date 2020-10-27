package com.ahsel.simbirsoft.models;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Words {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String word;

    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Words() {
    }

    public Words(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
