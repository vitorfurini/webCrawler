package com.axreng.backend;

import com.axreng.backend.com.axreng.backend.manager.WebCrawlerManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final String BASE_URL = System.getenv("BASE_URL");
        final String KEYWORD = System.getenv("KEYWORD");
        final String MAX_RESULTS = System.getenv("MAX_RESULTS");

        WebCrawlerManager webCrawlerManager = new WebCrawlerManager(BASE_URL, KEYWORD, MAX_RESULTS);
        webCrawlerManager.executeCrawling();

    }
}
