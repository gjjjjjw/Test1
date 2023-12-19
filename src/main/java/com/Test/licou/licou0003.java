package com.Test.licou;

import java.util.ArrayList;
import java.util.List;

public class licou0003 {

    public static void main(String[] args) {
        int i = new licou0003().lengthOfLongestSubstring("au");
        System.out.println(i);
    }


    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        String[] split = s.split("");

        int max = 0;
        int maxmax = 0;
        int head = 0;
        List<String> maxs = new ArrayList<>();
        if(split.length != 0){
            max = 1;
        }

        for (int i = 0; i < split.length; i++) {
            if(maxs.size() > 0){
                int eqs = eqs(maxs, split[i]);
                if(eqs != -1){
                    if(maxmax < max){
                        maxmax = max;
                    }
                    maxs = new ArrayList<>();
                    i= head + eqs;
                }else {
                    maxs.add(split[i]);
                    max = maxs.size();
                }
            }else {
                head = i ;
                maxs.add(split[i]);

            }
        }
        return Math.max(maxmax, max);
    }

    private int eqs(List<String> maxs,String s){
        int dingwei = -1;
        if(maxs.get(0).equals(s)){
            dingwei = 0;
        }
        for (int i = 0; i < maxs.size(); i++) {
            if(s.equals(maxs.get(i))){
                dingwei = i;
            }
        }
        return dingwei;
    }
}
