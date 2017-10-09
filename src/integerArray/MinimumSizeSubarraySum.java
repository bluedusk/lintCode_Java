package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/10/3.
 */
public class MinimumSizeSubarraySum {

    public int minimumSize(int[] nums, int s) {
        // write your code here
        int j = 0, i = 0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s) {
                sum += nums[j];
                j ++;
            }
            if(sum >=s) {
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        return ans;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {2,3,1,2,4,3};
        int[][] AA = {};
        String str1 = "";
        MinimumSizeSubarraySum x = new MinimumSizeSubarraySum();
        x.minimumSize(A,7);


    }

}
