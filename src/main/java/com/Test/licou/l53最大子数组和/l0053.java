package com.Test.licou.l53最大子数组和;

public class l0053 {

    public static void main(String[] args) {

//                    d  s d  s d d s  d
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        //         -2,1,-2,4, 3,5 6, 1 5

        long l = System.currentTimeMillis();
        int i = new l0053().maxSubArray(a);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(i);
    }
    public int maxSubArray(int[] nums) {

        int max=0;
        int pmax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.max(max+nums[i],nums[i]);
            max = nums[i];
            pmax = Math.max(pmax,max);

        }
        return pmax;
    }
}

//n*(n-1)
/*        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i] + nums[i-1]){
                nums[i] = nums[i] + nums[i-1];
                max = Math.max(max,nums[i]);
            }else {
                max = Math.max(max,nums[i]);
            }
        }*/