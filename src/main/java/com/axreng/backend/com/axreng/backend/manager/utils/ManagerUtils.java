package com.axreng.backend.com.axreng.backend.manager.utils;

import com.axreng.backend.com.axreng.backend.manager.exception.Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManagerUtils {

    public URL verifyBaseURL(String inputUrl) throws Exceptions {
        if (inputUrl == null) {
            throw new Exceptions("Item obrigatório: " + inputUrl);
        }
        try {
            if (!inputUrl.endsWith("/")) {
                inputUrl = inputUrl + "/";
            }

            URL url = new URL(inputUrl);
            url.toURI();

            return url;
        } catch (MalformedURLException | URISyntaxException e) {
            throw new Exceptions(inputUrl, e.getCause());
        }
    }

    public String verifyKeyword(String keyword) throws Exceptions {
        if (Objects.isNull(keyword)) {
            throw new Exceptions("Item obrigatório: " + keyword);
        } else if (!keyword.matches("^[a-zA-Z0-9_]*$")) {
            throw new Exceptions("Keyword inválida! Necessário conter ao menos 4 letras");
        } else if (keyword.length() < 4 || keyword.length() > 20) {
            throw new Exceptions(keyword.length());
        }
        return keyword;
    }

    public int verifyMaxResults(String maxResults) {
        int maxResults1 = maxResults == null ? -1 : Integer.parseInt(maxResults);

        if(maxResults1 == 0 || maxResults1 < -1){
            return -1;
        }
        return maxResults1;
    }

    public void printResults(String baseUrl, String keyword, Set<String> resultList) {
        System.out.println("Search starting with base URL " + baseUrl + " and keyword '" + keyword + "'");

        resultList.forEach(result -> System.out.println("Results found: " + result));

        System.out.println("Search finished with " + resultList.size() + " results found");
    }

    public List<String> getHtmlLines(URL url) throws IOException {

        BufferedReader htmlLines = new BufferedReader(new InputStreamReader(url.openStream()));
        Stream<String> lines = htmlLines.lines();

        return lines.collect(Collectors.toList());
    }
}
