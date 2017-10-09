package integerArray;

/**
 * Created by Lenovo on 2017/9/26.
 * http://www.cnblogs.com/grandyang/p/4402392.html
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int res = 0, mx = 0, n = height.length;
        int[] dp = new int[n];
        // 左边最大值
        for (int i = 0; i < n; ++i) {
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.min(dp[i], mx);
            mx = Math.max(mx, height[i]);
            if (dp[i] - height[i] > 0) {
                res += dp[i] - height[i];
            }
        }
        return res;
    }

}
