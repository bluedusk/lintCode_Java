package integerArray;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by Lenovo on 2017/9/14.
 * http://www.lintcode.com/en/problem/two-sum-input-array-is-sorted/
 *
 * 数字一定要判断0这个边界条件；
 */
public class TwoSum2 {

    //
    public static int[] twoSum(int[] nums, int target) {
        // write your code here

        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //根据假设exactly one solution，如果出现重复；
            if (table.containsKey(nums[i]) && nums[i] * 2 == target) {
                result[0] = i;
                result[1] = i + 1;
                return result;
            }
            table.put(nums[i], i);

            // if found
            // 特殊情况 {-1,0,1} target == nums[i] == 0;
            if (table.containsKey(target - nums[i]) && !(target == 0 && nums[i] == 0)) {
                result[0] = table.get(target - nums[i]) + 1;
                result[1] = table.get(nums[i]) + 1;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = {};
        int[] A = {-1, 0, 1};
        int[] A1 = {-72, -34, -33, -5, 1, 2, 3, 5, 5, 6, 7, 8, 12, 99, 100};

        twoSum(A, 0);
    }


}
