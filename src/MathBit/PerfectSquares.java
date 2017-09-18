package MathBit;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/9/8.
 */
public class PerfectSquares {


    public static void main(String[] args){

        numSquares(5);

    }
    /*
    * 其中dp[i]表示正整数i能少能由多个完全平方数组成，那么我们求n，就是返回dp[n]即可，也就是dp数组的最后一个数字
    * */
    public static int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1; // 数字由一个平方和构成，如1,4,9
        }

        // 由一个以上平方和构成的数字
        // dp[i - j * j] + 1  ： i = (i-j*j) + (j*j)
        // 因此 d[i]  = d[i-j*j] + d[j*j]; (d[j*j] == 1);
        // 例如 d[7] = d[3] + d[4]; d[7] = d[6] + d[1]; 取两个d[7]较小的一个

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


// version 1 DP
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares2(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 0; i <= n; ++i)
            for (int j = 0; i + j * j <= n; ++j)
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

        return dp[n];
    }


// version 2  Math
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares3(int n) {
        // Write your code here
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i <= n; ++i) {
            int j = (int)Math.sqrt(n * 1.0 - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0)
                    res += 1;
                if (j > 0)
                    res += 1;
                return res;
            }
        }
        return 3;
    }
}
