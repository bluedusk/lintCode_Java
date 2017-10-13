package dp;

/**
 * Created by Lenovo on 2017/10/4.
 */
public class HouseRobber {

    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }

        // 注意可能会超限，所以用long
        long[] dp = new long[A.length + 1];
        dp[0] = 0;
        dp[1] = A[0];

        for (int i = 2; i < A.length + 1; i++) {

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i - 1]);
        }

        return dp[A.length];

    }

    //0 3 6 8 2 7 4 9 6 8 3 7 4
}
