package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/7/6.
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72958
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // write your code here
        int temp = nums[nums.length-1]+1;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = temp;
            }
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == temp){
                return i;
            }
        }

        return nums.length;

    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 1) return nums.length;

        int newIndex = 0;
        // i++ 找到一个不重复的
        // newIndwx++ 把这个不重复的放在哪
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newIndex]) {
                newIndex++;
                nums[newIndex] = nums[i];
            }
        }

        return newIndex + 1;
    }
}
