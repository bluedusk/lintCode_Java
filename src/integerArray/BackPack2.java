package integerArray;

/**
 * Created by Lenovo on 2017/9/30.
 */
public class BackPack2 {

    // 二维DP
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[][] dp = new int[A.length + 1][m + 1];
        for(int i = 0; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(A[i-1] > j){
                    dp[i][j] = dp[(i-1)][j];
                }
                else{
                    dp[i][j] = Math.max(dp[(i-1)][j], dp[(i-1)][j-A[i-1]] + V[i-1]);
                }
            }
        }
        return dp[A.length][m];
    }
    //
    public int backPackII2(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m+1];
        for (int i = 0; i <=m ; ++i) f[i] = 0;
        int n = A.length , i, j;
        for(i = 0; i < n; i++){
            for(j = m; j >= A[i]; j--){
                if (f[j] < f[j - A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
            }
        }
        return f[m];
    }
}
