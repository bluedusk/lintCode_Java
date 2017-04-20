package exhaustiveSearch;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/4/19.
 * http://www.lintcode.com/en/problem/previous-permutation/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73054
 */
public class PreviousPermuation {

    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            return null;
        }

        int len = nums.size();
        // 从后往前找 i = len - 2;
        for (int i = len - 2; i >= 0; i--) {
            if (nums.get(i) > nums.get(i+1)) {
                int j;
                for (j = len - 1; j > i - 1; j--) {
                    if (nums.get(j) < nums.get(i)) {
                        break;
                    }
                }

                swap(nums, i, j);
                reverse(nums, i + 1, len-1);
                return nums;
            }
        }

        // 如果已经是最大数如4321的结果是1234
        // 这时候也需要reverse
        reverse(nums, 0, len-1);
        return nums;
    }



    void swap(ArrayList<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,tmp);
    }

    void reverse(ArrayList<Integer> nums, int beg, int end) {
        for (int i = beg, j = end; i < j; i ++, j --) {
            swap(nums, i, j);
        }
    }
}
