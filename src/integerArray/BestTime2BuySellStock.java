package integerArray;

/**
 * Created by Lenovo on 2017/9/29.
 */
public class BestTime2BuySellStock {

    // solution 1 : TLE 哈哈
    public int maxProfit(int[] prices) {
        // write your code here
        int profit = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                profit = prices[j] - prices[i];
                maxProfit = Math.max(profit,maxProfit);
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        // write your code here
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - minPrice;
            minPrice = Math.min(prices[i],minPrice);
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}
