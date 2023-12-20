package com.Test.licou.lic寻找峰值II;

public class licou1901 {

    public static void main(String[] args) {

        int[][] mat = { {47,30,35,8,25},
                        {6,36,19,41,40},
                        {24,37,13,46,5},
                        {3,43,15,50,19},
                        {6,15,7,25,18}};

        int[] peakGrid = new licou1901().findPeakGrid(mat);
        System.out.println(peakGrid[0] + "," + peakGrid[1]);
    }


    public int[] findPeakGrid(int[][] mat) {



        int m =  mat.length /2;     //行
        int n =  mat[0].length /2;  //列

        while (true){
            if(n-1 >= 0){
                if(mat[m][n] < mat[m][n-1]){
                    n = n-1;
                    continue;
                }
            }
            if(m-1 >= 0){
                if(mat[m][n] < mat[m-1][n]){
                    m = m-1;
                    continue;
                }
            }
            if(n+1 <= mat[0].length){
                if(mat[m][n] < mat[m][n+1]){
                    n = n+1;
                    continue;
                }
            }
            if(m+1 <= mat.length){
                if(mat[m][n] < mat[m-1][n]){
                    m = m+1;
                    continue;
                }
            }
            return new int[]{m,n};
        }

    }

}
