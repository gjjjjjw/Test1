package com.Test.licou;

import java.util.*;

public class licou2258 {

    public static void main(String[] args) {
        int[][] es = {
                {0,0,0,0,0},
                {0,2,0,2,0},
                {0,2,0,2,0},
                {0,2,1,2,0},
                {0,2,2,2,0},
                {0,0,0,0,0}
        };
        int i = new licou2258().maximumMinutes(es);
        System.out.println(i);
        for (int j = 0; j < es.length; j++) {
            System.out.println(Arrays.toString(es[j]));
        }
    }

    List<ArrayList<Integer>> renlist = new ArrayList<>();
    List<ArrayList<Integer>> huolist = new ArrayList<>();
    List<ArrayList<Integer>> huoren = new ArrayList<>();

    public int maximumMinutes(int[][] grid) {
        //   0 是草地; 1 是火; 2 是墙; 4 人的位置;

        //找到开始时所有火的位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(i);
                    v.add(j);
                    huolist.add(v);
                }
            }
        }


        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(0);
        renlist.add(integers);

        Integer ren = 0; // -1是没有找到房子 0是还在找 1是找到了房子
        Integer huo = 0; // -1是没有找到房子 0是还在找 1是找到了房子

        int r = 0;
        int h = 0;

        //人走的步数
        while (ren == 0) {
            ren = ren(grid);//人走一分钟
            r++;
            if(ren == -1){
                return -1;
            }
        }

        //火走的步数
        while (huo == 0) {
            huo = huo(grid);//火烧一分钟
            h++;
            if(huo == -1){
                return 1000000000;
            }
        }
        if(h-r<0){
            return -1;
        }
        if(grid[grid.length-2][grid[0].length-1] == 4){
            return h-r;
        }
        if(grid[grid.length-1][grid[0].length-2] == 4){
            return h-r;
        }

        return h-r-1;
    }

    //每一分钟人走的位置以及删除上次人的位置
    private Integer ren(int[][] grid) {
        int size = renlist.size();
        if(size > 0){
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            for (ArrayList<Integer> list : renlist) {
                Integer hangNum = list.get(0);
                Integer lieNum = list.get(1);
                if(hangNum+1 < grid.length && grid[hangNum+1][lieNum] == 0){
                    if(hangNum+1 == grid.length-1 && lieNum == grid[0].length-1){
                        grid[hangNum+1][lieNum] = 4;
                        return 1;//找到房子
                    }
                    grid[hangNum+1][lieNum] = 4;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum+1);
                    v.add(lieNum);
                    arrayLists.add(v);
                }
                if(hangNum-1 >= 0 && grid[hangNum-1][lieNum] == 0){
                    if(hangNum-1 == grid.length-1 && lieNum == grid[0].length-1){
                        grid[hangNum-1][lieNum] = 4;
                        return 1;//找到房子
                    }
                    grid[hangNum-1][lieNum] = 4;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum-1);
                    v.add(lieNum);
                    arrayLists.add(v);
                }
                if(lieNum+1 < grid[0].length && grid[hangNum][lieNum+1] == 0){
                    if(hangNum == grid.length-1 && lieNum+1 == grid[0].length-1){
                        grid[hangNum][lieNum+1] = 4;
                        return 1;//找到房子
                    }
                    grid[hangNum][lieNum+1] = 4;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum);
                    v.add(lieNum+1);
                    arrayLists.add(v);
                }
                if(lieNum-1 >= 0 && grid[hangNum][lieNum-1] == 0){
                    if(hangNum == grid.length-1 && lieNum-1 == grid[0].length-1){
                        grid[hangNum][lieNum-1] = 4;
                        return 1;//找到房子
                    }
                    grid[hangNum][lieNum-1] = 4;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum);
                    v.add(lieNum-1);
                    arrayLists.add(v);
                }
            }
            renlist.clear();
            renlist = arrayLists;
            return 0;
        }
        return -1;
    }

    //每一分钟火的扩散以及删除上次火的位置
    private Integer huo(int[][] grid) {
        int size = huolist.size();
        if(size > 0){
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            for (List<Integer> list : huolist) {
                Integer hangNum = list.get(0);
                Integer lieNum = list.get(1);
                if(hangNum+1 < grid.length && (grid[hangNum+1][lieNum] == 0 || grid[hangNum+1][lieNum] == 4)){
                    if(hangNum+1 == grid.length-1 && lieNum == grid[0].length-1){
                        return 1;//找到房子
                    }
                    grid[hangNum+1][lieNum] = 1;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum+1);
                    v.add(lieNum);
                    arrayLists.add(v);
                }
                if(hangNum-1 >= 0 && (grid[hangNum-1][lieNum] == 0 || grid[hangNum-1][lieNum] == 4)){
                    if(hangNum-1 == grid.length-1 && lieNum == grid[0].length-1){
                        return 1;//找到房子
                    }
                    grid[hangNum-1][lieNum] = 1;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum-1);
                    v.add(lieNum);
                    arrayLists.add(v);
                }
                if(lieNum+1 < grid[0].length && (grid[hangNum][lieNum+1] == 0 || grid[hangNum][lieNum+1] == 4)){
                    if(hangNum == grid.length-1 && lieNum+1 == grid[0].length-1){
                        return 1;//找到房子
                    }
                    grid[hangNum][lieNum+1] = 1;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum);
                    v.add(lieNum+1);
                    arrayLists.add(v);
                }
                if(lieNum-1 >= 0 && (grid[hangNum][lieNum-1] == 0 || grid[hangNum][lieNum-1] == 4)){
                    if(hangNum == grid.length-1 && lieNum-1 == grid[0].length-1){
                        return 1;//找到房子
                    }
                    grid[hangNum][lieNum-1] = 1;
                    ArrayList<Integer> v = new ArrayList<>();
                    v.add(hangNum);
                    v.add(lieNum-1);
                    arrayLists.add(v);
                }
            }
            huolist.clear();
            huolist = arrayLists;
            return 0;
        }
        return -1;
    }



}
