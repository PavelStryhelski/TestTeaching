package com.qulix.ft.teachingSite;

import org.apache.commons.lang3.RandomStringUtils;

public class UserMessage {

    private String headline;
    private String text;

    public UserMessage(){
        headline = generateRandomMessage();
        text = generateRandomMessage();
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    private static String generateRandomMessage(){

        return RandomStringUtils.randomAlphabetic(10);

    }
}
