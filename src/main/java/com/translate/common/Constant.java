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
        O_CONDITION_WORDS.put("","");
        O_CONDITION_WORDS.put("","");
        O_CONDITION_WORDS.put("","");
        O_CONDITION_WORDS.put("","");
        O_CONDITION_WORDS.put("","");
        O_CONDITION_WORDS.put("","");

        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
        F_CONDITION_WORDS.put("","");
    }
}
