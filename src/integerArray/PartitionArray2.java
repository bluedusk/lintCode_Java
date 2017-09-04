package integerArray;

/**
 * Created by Lenovo on 2017/9/1.
 * http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72963
 */
public class PartitionArray2 {
    public void partitionArray(int[] nums) {
        // write your code here;

        if (nums == null) return;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // odd number
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            // even number
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            // swap
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
}
