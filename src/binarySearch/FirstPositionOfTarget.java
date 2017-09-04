package binarySearch;

/**
 * Created by Lenovo on 2017/3/13.
 * http://www.lintcode.com/en/problem/first-position-of-target/
 * http://www.jiuzhang.com/solutions/first-position-of-target/
 *
 * 注意需要O(logn)的时间复杂度，使用二分查找法
 */
public class FirstPositionOfTarget {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length-1;
        // 注意1 while 条件
        // 注意2 target = > < 三种情况
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                end =  mid; // 如果相等，继续在前面找，因为前面可能还有这个数字
            }
            else if(target < nums[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        if (nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }

}
