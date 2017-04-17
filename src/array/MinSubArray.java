package array;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/4/12.
 * http://www.lintcode.com/en/problem/minimum-subarray/
 *
 */
public class MinSubArray {

    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     *
     * Version 1: Greedy
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int sum = 0, min = Integer.MAX_VALUE;

        for (int i=0; i<nums.size();i++){
            sum += nums.get(i);
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
        }
        return min;
    }


}
