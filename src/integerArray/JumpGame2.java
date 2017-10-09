package integerArray;

/**
 * Created by Lenovo on 2017/9/26.
 */
public class JumpGame2 {

    // version1 : dp 和jump game1思路相同；
    public int jump(int[] A) {
        // state
        int[] steps = new int[A.length];

        // initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        // function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                // j + A[j] > = i 说明j元素一步就能到达i, 因此下面有 step[j] + 1
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        // answer
        return steps[A.length - 1];
    }

    // version 2 : greedy
    public int jump2(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                //
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }

    /*
 * We use "last" to keep track of the maximum distance that has been reached
 * by using the minimum steps "ret", whereas "curr" is the maximum distance
 * that can be reached by using "ret+1" steps. Thus,
 * curr = max(i+A[i]) where 0 <= i <= last.
 */

    public int jump(int A[], int n) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < n; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i+A[i]);
        }

        return ret;
    }
}
