package com.codegym.photooftheday;

import java.util.Arrays;
import java.util.List;

public class BadWordFilter {
    private static final List<String> BAD_WORDS = Arrays.asList("xấu", "ngu", "đần", "dốt");
    public static boolean containsBadWords(String content) {
        if (content == null) return false;
        String normalized = content.toLowerCase();
        return BAD_WORDS.stream().anyMatch(normalized::contains);
    }
}