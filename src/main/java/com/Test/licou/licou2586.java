package com.Test.licou;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class licou2586 {
    public static void main(String[] args) {
        String[] words = {"are", "amy", "u"};
        int left = 0;
        int right = 2;
        int i = new licou2586().vowelStrings(words, left, right);
        System.out.println(i);
    }

    public int vowelStrings(String[] words, int left, int right) {
        List<Character> vowels = new ArrayList<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};

        return 0;
    }
}


