package com.Test.licou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class licou2103 {
    public static void main(String[] args) {
        int r3G2B1 = new licou2103().countPoints("B0B6G0R6R0R6G9");
        System.out.println(r3G2B1);
    }


    public int countPoints(String rings) {
        ArrayList<Set<String>> sets = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sets.add(new HashSet<>());
        }

        String[] split = rings.split("");
        for (int i = 0; i < split.length; i += 2) {
            sets.get(Integer.valueOf(split[i+1])).add(split[i]);

        }
        int num = 0;
        for (Set<String> set : sets) {
            if(set.size() >= 3){
                num++;
            }
        }
        return num;
    }


/*    public int countPoints(String rings) {

        HashSet<String> strings1 = new HashSet<>();

        HashMap<String, Set<String>> integerSetHashMap = new HashMap<>();

        String[] split = rings.split("");
        for (int i = 0; i < split.length; i=i+2) {
            integerSetHashMap.computeIfAbsent(split[i+1],key ->new HashSet<>()).add(split[i]);
            Set<String> strings = integerSetHashMap.get(split[i + 1]);
            if(strings.size()>=3){
                strings1.add(split[i + 1]);
            }
        }
        return strings1.size();
    }*/
}
