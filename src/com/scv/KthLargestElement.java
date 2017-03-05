package com.scv;

/**
 * Created by openworld on 17/3/4.
 * http://www.lintcode.com/zh-cn/problem/kth-largest-element/
 * http://www.jiuzhang.com/solutions/kth-largest-element/
 */
public class KthLargestElement {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     * 快速排序
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    /**
     *
     * @param nums 目标数组
     * @param l 左指针
     * @param r 右指针
     * @param k pivot指针
     * @return
     */
    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }

    /**
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }
}
