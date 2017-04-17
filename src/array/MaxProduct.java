package array;

import java.util.List;

/**
 * Created by Lenovo on 2017/4/11.
 * http://www.lintcode.com/en/problem/maximum-product-subarray/
 * http://www.jiuzhang.com/solutions/maximum-product-subarray/
 */
public class MaxProduct {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        // 需要两个数组存储i之前的数中product的最大和最小
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        min[0] = max[0] = nums[0];
        int result = nums[0];
        // i从1开始
        for (int i = 1; i < nums.length; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            // 每一次循环选出当前最大，循环结束选出所有最大
            result = Math.max(result, max[i]);
        }

        return result;
    }

    // LeetCode version:
    public class Solution {
        /**
         * @param nums: an array of integers
         * @return: an integer
         */
        public int maxProduct(List<Integer> nums) {
            int[] max = new int[nums.size()];
            int[] min = new int[nums.size()];

            min[0] = max[0] = nums.get(0);
            int result = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                min[i] = max[i] = nums.get(i);
                if (nums.get(i) > 0) {
                    max[i] = Math.max(max[i], max[i - 1] * nums.get(i));
                    min[i] = Math.min(min[i], min[i - 1] * nums.get(i));
                } else if (nums.get(i) < 0) {
                    max[i] = Math.max(max[i], min[i - 1] * nums.get(i));
                    min[i] = Math.min(min[i], max[i - 1] * nums.get(i));
                }
                result = Math.max(result, max[i]);
            }

            return result;
        }
    }
}
