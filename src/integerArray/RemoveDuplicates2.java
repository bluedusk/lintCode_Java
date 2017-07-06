package integerArray;

/**
 * Created by Lenovo on 2017/7/6.
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array-ii/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72959
 */
public class RemoveDuplicates2 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 2) return nums.length;

        int newIndex = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[newIndex] || nums[i] != nums[newIndex - 1]) {
                newIndex++;
                nums[newIndex] = nums[i];
            }
        }

        return newIndex + 1;
    }

    public static void main(String[] args){

        int[] nums = {1,1,1,2,2,3,3};

        removeDuplicates(nums);
    }
}
