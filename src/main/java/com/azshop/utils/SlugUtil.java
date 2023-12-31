package com.azshop.utils;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;


public class SlugUtil {
    private static final Pattern NONLATIN = Pattern.compile("[^\\p{IsAlphabetic}0-9-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");

    public static String toSlug(String input) {
    	LocalDateTime timeNow = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("-yyyyMMddHHmmssSSS");
    	
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        slug = EDGESDHASHES.matcher(slug).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH)+timeNow.format(formatter);
    }
    
}

