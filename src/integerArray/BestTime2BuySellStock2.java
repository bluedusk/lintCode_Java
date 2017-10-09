package integerArray;

/**
 * Created by Lenovo on 2017/9/29.
 */
public class BestTime2BuySellStock2 {

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
