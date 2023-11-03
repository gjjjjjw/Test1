package com.Test.licou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class licou2127 {

    public static void main(String[] args) {

        int[] favorite = {1, 0, 3, 4, 3};

        maximumInvitations(favorite);
    }



    public static int maximumInvitations(int[] favorite) {



        Integer big = 0;



        Integer tou = null;

        for (int i = 0; i < favorite.length; i++) {
            tou = favorite[i];

            HashSet<Integer> integers = new HashSet<>();
            Integer dijige;
            do {
                dijige = getnext(tou,favorite);
                integers.add(dijige);

            } while (tou != favorite[dijige]);


        }

        return 1;
    }

    private static Integer getnext(Integer tou, int[] favorite) {

        for (int i = 0; i < favorite.length; i++) {

            if(tou == favorite[i]){
                return i;
            }
        }

        return null;
    }


}

/*{0=[1], 1=[0], 2=[3], 3=[2, 4]}
        [1]
        [0]
        [3]
        [2, 4]*/

/*        HashMap<Integer, Set<Integer>> zong = new HashMap<>();

        HashMap<Integer, Set<Integer>> stringHashMap = new HashMap<>();

        for (int i = 0; i < favorite.length; i++) {
            Integer bei = favorite[i];
            stringHashMap.computeIfAbsent(bei, k -> new HashSet<>()).add(i);
        }

        System.out.println(stringHashMap);
        Set<Integer> beis = stringHashMap.keySet();

        Integer tou = null;

        for (Integer bei : beis) {
            Set<Integer> integers = stringHashMap.get(bei);

            for (Integer integer : integers) {
                tou = integer;
                Set<Integer> integers1 = new HashSet<>();
                integers1.add(tou);
//                System.out.println(tou);

            }
        }*/

