package com.scv;

import java.util.Arrays;

/**
 ** Created by daniel on 2015/7/19.
 * Find the Missing Number
 * http://www.lintcode.com/en/problem/find-the-missing-number/
 */
public class LC1 {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */


    static int[] test1 = {0};
    static int[] test2 = {0,1,2,3};
    static int[] test3 = {0,1,2,3,5};

    public static int findMissing(int[] nums) {
        // write your code here

        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length ; i++) {

            if (i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static int findMissing1(int[] nums) {
        // write your code here

        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        int sum = n*(n+1)/2;

        for (int i = 0; i < nums.length ; i++) {

            sum = sum - nums[i];

        }
        return sum;
    }


    public static void main(String[] args) {
        // write your code here

        System.out.println(findMissing1(test1));
        System.out.println(findMissing1(test2));
        System.out.println(findMissing1(test3));
    }
}
