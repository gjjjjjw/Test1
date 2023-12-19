package com.Test.licou.licou2736;

import org.apache.commons.math3.analysis.function.Max;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class licou2736001 {
    public static void main(String[] args) {
//        int[] nums1 = {4,3,1,2};
//        int[] nums2 = {2,4,9,5};
//        int[][] queries = {{4,1},{1,3},{2,5}};

        /*int[] nums1 = new int[100000];
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
        }*/

        long l = System.currentTimeMillis();
        //int[] ints = new licou2736001().maximumSumQueries(nums1, nums2, queries);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] a = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int max = -1;
            for (int j = 0; j < nums1.length; j++) {
                if(nums1[j] >= query[0] && nums2[j] >= query[1]){
                    max = Math.max(max, nums1[j] + nums2[j]);
                }
            }
            a[i] = max;
        }
        return a;
    }



}
