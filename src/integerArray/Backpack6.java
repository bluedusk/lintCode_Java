package integerArray;

/**
 * Created by Lenovo on 2017/10/13.
 * DP
 * dp[i]表示target为i时，所有可能的组合
 */
public class Backpack6 {
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; ++i)
            for (int  j = 0; j < nums.length; ++j)
                if (i >= nums[j])
                {
                    f[i] += f[i - nums[j]];
                }

        return f[target];
    }
}
