package com.translate.common;

import java.util.HashMap;
import java.util.Map;

/**
 * project constant data
 *
 * @Autor:Dave
 * @Create:2017-09-27 21:04
 */
public class Constant {
    public static final Character[] Y_CONDITION_CHAR = new Character[]{'y'};
    public static final String[] SH_CONDITION_CHAR = new String[]{"s","sh","ch","x"};
    public static final Character[] O_CONDITION_CHAR = new Character[]{'o'};
    public static final String[] F_CONDITION_CHAR = new String[]{"f","fe"};

    public static final Map<String,String> O_CONDITION_WORDS = new HashMap<>();
    public static final Map<String,String> F_CONDITION_WORDS = new HashMap<>();

    static {
        O_CONDITION_WORDS.put("photos","photo");
        O_CONDITION_WORDS.put("pianos","piano");
        O_CONDITION_WORDS.put("radios","radio");
        O_CONDITION_WORDS.put("zoos","zoo");
        O_CONDITION_WORDS.put("potatoes","potato");
        O_CONDITION_WORDS.put("tomatoes","tomato");

        F_CONDITION_WORDS.put("beliefs","belief");
        F_CONDITION_WORDS.put("roofs","roof");
        F_CONDITION_WORDS.put("safes","safe");
        F_CONDITION_WORDS.put("gulfs","gulf");
        F_CONDITION_WORDS.put("halves","half");
        F_CONDITION_WORDS.put("knives","knife");
        F_CONDITION_WORDS.put("leaves","leaf");
        F_CONDITION_WORDS.put("wolves","wolf");
        F_CONDITION_WORDS.put("wives","wife");
        F_CONDITION_WORDS.put("lives","life");
        F_CONDITION_WORDS.put("thieves","thief");
    }
}
