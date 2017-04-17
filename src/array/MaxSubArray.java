package array;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/4/11.
 * http://www.lintcode.com/en/problem/maximum-subarray/
 * http://www.jiuzhang.com/solutions/maximum-subarray/
 *
 * 有三种解法
 */
public class MaxSubArray {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     *
     * Version1: greedy
     * 最好理解的一种
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0){
            return -1;
        }
        // 注意必须设置为 MIN_VALUE
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0); // 如果sum<0则可以抛弃，因为后面的sum肯定加上前面的大了
        }
        return max;
    }

    /**
     *
     * @param A
     * @return
     *
     * Version 2:
     */
    public int maxSubArray2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        // 对每一个i, 计算0-i的sum， 和minSum，minSum代表前面元素的sum中最小的一段，实际上是subarry最小负数和
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum); // 比较每一个i的sum-minSum
            minSum = Math.min(minSum, sum);
        }

        return max;
    }


    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     *
     * Version 3: ArrayList
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums.size()==0)
            return 0;
        int n = nums.size();
        int []global = new int[n];
        int []local = new int[n];
        global[0] = nums.get(0);
        local[0] = nums.get(0);
        for(int i=1;i<n;i++)
        {
            local[i] = Math.max(nums.get(i),local[i-1]+nums.get(i));
            global[i] = Math.max(local[i],global[i-1]);
        }
        return global[n-1];
    }


}
