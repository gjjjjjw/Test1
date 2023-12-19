package com.Test.licou.licaou2132邮票;

public class li2132 {

    public static void main(String[] args) {

//        /*int[][] grid = new int[36][59];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if((i == 0 ||i==1) && j >= 52){
//                    grid[i][j] = 1;
//                }else if(i >= 27 && j==0){
//                    grid[i][j] = 1;
//                } if( i>= 31 && j <= 2){
//                    grid[i][j] = 1;
//                }else {
//                    grid[i][j] = 0;
//                }
//            }
//
//        }
//
//        grid[34][58] = 1;
//        grid[35][58] = 1;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                System.out.print(grid[i][j]+",");
//            }
//            System.out.println();
//        }*/

        int stampHeight = 2;
        int stampWidth = 2;

        int[][] grid = {{0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,0,1},
                        {0,0,0,1,1}};


        boolean b = new li2132().possibleToStamp(grid, stampHeight, stampWidth);
        System.out.println(b);

    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {

        int count = 0;
        int n = 0;

        for (int i = 0; i < grid.length; i++) {
            a:for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    for (n = j; n < grid[i].length; n++) {
                        if (grid[i][n] == 0) {
                            count++;
                        } else {
                            if (count < stampWidth) {
                                return false;
                            } else {
                                count = 0;
                                j = n;
                                break a;
                            }
                        }
                    }
                    if (count < stampWidth) {
                        for (int i1 = 0; i1 < grid.length; i1++) {
                            for (int i2 = 0; i2 < grid[0].length; i2++) {
                                System.out.print(grid[i1][i2]+",");
                            }
                            System.out.println();
                        }
                        return false;
                    } else {
                        j = n;
                        count = 0;
                    }
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            a:for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    for (n = j; n < grid.length; n++) {
                        if (grid[n][i] == 0) {
                            count++;
                        } else {
                            if (count < stampHeight) {
                                return false;
                            } else {
                                count = 0;
                                j = n;
                                break a;
                            }
                        }
                    }
                    if (count < stampHeight) {
                        return false;
                    } else {
                        count = 0;
                        j = n;
                    }
                }
            }
        }

        return true;
    }

}
