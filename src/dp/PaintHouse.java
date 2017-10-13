package dp;

/**
 * Created by Lenovo on 2017/10/12.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0){
            return 0;
        }

        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < m; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][1],dp[i-1][0]);
        }

        return Math.min(dp[m-1][0],Math.min(dp[m-1][1],dp[m-1][2]));
    }
}
