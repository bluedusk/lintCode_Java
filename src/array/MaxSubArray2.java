package array;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/4/11.
 * http://www.jiuzhang.com/solutions/maximum-subarray-ii/
 * 这个题的思路是，因为 两个subarray 一定不重叠
 所以必定存在一条分割线
 分开这两个 subarrays
 所以 最后的部分里：
 max = Integer.MIN_VALUE;
 for(int i = 0; i < size - 1; i++){
 max = Math.max(max, left[i] + right[i + 1]);
 }
 return max;
 这里是在枚举 这条分割线的位置
 然后 left[] 和 right[] 里分别存的是，某个位置往左的 maximum subarray 和往右的 maximum subarray
 */
public class MaxSubArray2 {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        // 每一个i位置，i左边的subarray的sum最大值
        int[] left = new int[size];
        // 每一个i位置，i右边的subarray的sum最大值
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            // 这是求连续subarray最大sum的[模式]
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}
