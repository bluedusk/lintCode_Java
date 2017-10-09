package integerArray;

/**
 * Created by Lenovo on 2017/9/26.
 */
public class JumpGame {

    // version 0 : Dynamic Programming
    public boolean canJump2(int A[], int n) {
        int[] dp = new int[A.length];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], A[i - 1]) - 1;
            if (dp[i] < 0) return false;
        }
        return dp[n - 1] >= 0;
    }

    // version 1: Dynamic Programming
    // 这个方法，复杂度是 O(n^2) 可能会超时，但是依然需要掌握。
    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && A[j] >= i - j) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[A.length - 1];
    }
    // version 2: Greedy
    public boolean canJump1(int[] A) {
        // think it as merging n intervals
        if (A == null || A.length == 0) {
            return false;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && A[i] + i >= farthest) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }
}
