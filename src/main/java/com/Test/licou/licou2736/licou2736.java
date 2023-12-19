package com.Test.licou.licou2736;

import java.util.*;

public class licou2736 {

    public static void main(String[] args) {
//        int[] nums1 = {4,3,1,2};
//        int[] nums2 = {2,4,9,5};
//        int[][] queries = {{4,1},{1,3},{2,5}};

        int[] nums1 = new int[100000];
        int[] nums2 = new int[100000];
        int[][] queries = new int[100000][2];

        nums1[0] = 1;
        nums2[0] = 2;
        queries[0][0] = 1;
        queries[0][1] = 2;
        for (int i = 1; i <100000; i++) {
            nums1[i] = i+4 ;
            nums2[i] = 1 ;
            queries[i][0] = 1;
            queries[i][1] = 2;
        }

        long l = System.currentTimeMillis();
        int[] ints = new licou2736().maximumSumQueries(nums1, nums2, queries);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int length = queries.length;
        int[] a = new int[length];

        long l = System.currentTimeMillis();

        int[][] num = new int[nums1.length][3];

        int[][] bei = new int[nums1.length][3];

        for (int i = 0; i < nums1.length; i++) {
            num[i][0] = nums1[i] + nums2[i];
            num[i][1] = nums1[i];
            num[i][2] = nums2[i];
        }

        long l2 = System.currentTimeMillis();

        Arrays.sort(num,(n1,n2)->n2[0]-n1[0]);


        long l3 = System.currentTimeMillis();

        int beinum = 0;

        ll:
        for (int i = 0; i < queries.length; i++) {

            int i0 = queries[i][0];
            int i1 = queries[i][1];
            a[i] = -1;
            for (int k = 0; k <= beinum; k++) {
                if (i0 + i1 == bei[k][0]) {
                    int j0 = bei[k][1];
                    int j1 = bei[k][2];
                    if (j0 >= i0 && j1 >= i1) {
                        a[i] = j0 + j1;
                        continue ll;
                    }
                }
            }
//            if (a[i] == -1) {
                for (int j = 0; j < num.length; j++) {
                    int j0 = num[j][1];
                    int j1 = num[j][2];
                    if (j0 >= i0 && j1 >= i1) {
                        bei[beinum++] = num[j];
                        a[i] = j0 + j1;
                        j = num.length;
                    }
                }
            }
//        }
        long l5 = System.currentTimeMillis();

        System.out.println(l5-l3);
        System.out.println(l3-l2);
        System.out.println(l2-l);

        return a;
    }



    public int[] maximumSumQueries01(int[] nums1, int[] nums2, int[][] queries) {
        int length = queries.length;
        int[] a = new int[length];
        HashMap<Integer, ArrayList<Integer>> integerHashMap = new HashMap<>();

        long l = System.currentTimeMillis();

        int[][] num = new int[nums1.length][3];
        for (int i = 0; i < nums1.length; i++) {

            integerHashMap.computeIfAbsent(nums1[i]+nums2[i], k -> new ArrayList<>()).add(i);//1
        }

        long l2 = System.currentTimeMillis();

        Set<Integer> keySet = integerHashMap.keySet();//2

        TreeSet<Integer> treeSet = new TreeSet<>(keySet);

        long l3 = System.currentTimeMillis();

        ArrayList<Integer> treeSetList = new ArrayList<>(treeSet);//3

        long l4 = System.currentTimeMillis();

        for (int i = 0; i < queries.length; i++) {

            int i0 = queries[i][0];
            int i1 = queries[i][1];
            a[i] = -1;
            for (int j = treeSetList.size()-1; j >= 0; j--) {
                ArrayList<Integer> integers = integerHashMap.get(treeSetList.get(j));//4
                for (Integer integer : integers) {
                    int j0 = nums1[integer];
                    int j1 = nums2[integer];
                    if(j0 >= i0 && j1 >= i1){
                        a[i] = Math.max(a[i], j0+j1);
                        j=-1;
                    }
                }
            }
        }

        long l5 = System.currentTimeMillis();

        System.out.println(l5-l4);
        System.out.println(l4-l3);
        System.out.println(l3-l2);
        System.out.println(l2-l);

        return a;
    }


}
