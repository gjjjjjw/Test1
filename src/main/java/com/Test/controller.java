package com.Test;


import java.util.ArrayList;
import java.util.Iterator;

public class controller {








    public static void main(String[] args) {
        /*int[][] es = {{0,0}, {0,0}};
        new controller().maximumMinutes(es);*/

        ArrayList<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.remove(0);
        System.out.println(strings.get(0));

    }
    public int maximumMinutes(int[][] grid) {
        System.out.println(grid[0][0]);
        huo(grid);
        System.out.println(grid[0][0]);
        return 0;
    }

    private void huo(int[][] grid) {
        if(grid[3][3] != 0){
            System.out.println(1112312312);
        }
    }


}
  