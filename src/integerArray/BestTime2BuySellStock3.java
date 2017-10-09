package integerArray;

/**
 * Created by Lenovo on 2017/9/29.
 */
public class BestTime2BuySellStock3 {

    // solution 1 : TLE ...
    public int maxProfit(int[] prices) {
        // write your code here
        int max = 0;
        for (int i = 0; i < prices.length; i++) {

            int max1 = maxSigleProfit(prices,0,i);
            int max2 = maxSigleProfit(prices,i,prices.length);
            max = Math.max(max1+max2,max);
        }
        return max;
    }

    int maxSigleProfit(int[] prices ,int start, int end) {
        // write your code here
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int maxProfit = 0;
        int minPrice = prices[start];
        for (int i = start + 1; i < end; i++) {
            profit = prices[i] - minPrice;
            minPrice = Math.min(prices[i],minPrice);
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }

    // Solution 2

    public int maxProfit1(int[] prices) {
        // write your code here
        if (prices.length == 0) return 0;
        int n = prices.length;
        // 全局最优
        int[][] g = new int[n][3];
        // 局部最优
        int [][] l = new int[n][3];
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; ++j) {
                l[i][j] = Math.max(g[i - 1][j - 1] + Math.max(diff, 0), l[i - 1][j] + diff);
                g[i][j] = Math.max(l[i][j], g[i - 1][j]);
            }
        }
        return g[n - 1][2];
    }



}
