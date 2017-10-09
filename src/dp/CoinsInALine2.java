package dp;

/**
 * Created by Lenovo on 2017/10/3.
 * http://www.jiuzhang.com/solution/coins-in-a-line-ii/
 */
public class CoinsInALine2 {

    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;

        // sum代表从后往前的求和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i){
            sum[i] = sum[i -  1] + values[n - i];
        }
        // dp[i] 现在还剩i个硬币，现在当前取硬币的人最后最多取硬币价值
        int[] dp = new int[n + 1];
        dp[1] = values[n - 1];
        for (int i = 2; i <= n; ++i){
            dp[i] = sum[i] - Math.min(dp[i - 1], dp[i - 2]);
        }
        // 是否拿到多半
        return dp[n]  > sum[n] / 2;
    }
}
