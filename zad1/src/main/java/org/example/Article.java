package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Article {
    private String title;
    private String body;
    private int wordCount;
    private List<String> wordsOfArticle = new ArrayList<>();

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
        this.wordCount = body.split(" ").length;
        Collections.addAll(wordsOfArticle, body.split(" "));
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getWordCount() {
        return wordCount;
    }

    public List<String> getWordsOfArticle() {
        return wordsOfArticle;
    }
}
