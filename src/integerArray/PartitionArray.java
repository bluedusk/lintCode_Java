package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/6/14.
 */
public class PartitionArray {

    public int partitionArray(int[] nums, int k) {
        //write your code here

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=k){
                return i;
            }
        }
        return nums.length;
    }
    // solution 2 : Quick Sort
    public int partitionArray2(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }

            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        return left;
    }

}


