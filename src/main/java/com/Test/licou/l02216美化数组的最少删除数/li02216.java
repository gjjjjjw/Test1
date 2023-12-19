package com.Test.licou.l02216美化数组的最少删除数;

public class li02216 {


    public static void main(String[] args) {
        int[] a = {1,1,2,1,5,1};
        int i = new li02216().minDeletion(a);
        System.out.println(i);
    }

    public int minDeletion(int[] nums) {

        int length = nums.length;

        int a = 0;

        for (int i = 1; i < length; i++) {
            if(nums[i] == nums[i - 1]){
                a++;
            }else{
                i++;
            }
        }
        if((length - a) % 2  == 1){
            return a + 1;
        }
        return a;
    }
}
