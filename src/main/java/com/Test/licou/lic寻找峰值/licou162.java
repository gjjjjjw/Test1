package com.Test.licou.lic寻找峰值;

public class licou162 {

    public static void main(String[] args) {

        int [] nums = {};

        new licou162().findPeakElement(nums);

    }

    public int findPeakElement(int[] nums) {

        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }

        return 0;
    }
}
