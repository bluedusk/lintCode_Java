package dp;

/**
 * Created by Lenovo on 2017/10/12.
 */
public class PaintHouse2 {
    public int minCostII(int[][] costs) {

        if(costs == null || costs.length == 0){
            return 0;
        }

        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = costs;
        // 非常巧妙
        int min1 = -1, min2 = -1;


        for (int i = 0; i < m; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;
            for (int j = 0; j < n; j++) {
                if (j != last1) {
                    dp[i][j] += last1 < 0 ? 0 : dp[i - 1][last1];
                } else {
                    dp[i][j] += last2 < 0 ? 0 : dp[i - 1][last2];
                }
                // 保存最小和第二小的索引！
                if (min1 < 0 || dp[i][j] < dp[i][min1]) {
                    min2 = min1; min1 = j;
                } else if (min2 < 0 || dp[i][j] < dp[i][min2]) {
                    min2 = j;
                }
            }

        }
        return dp[m-1][min1];
    }
}
