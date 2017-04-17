package dp;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/4/14.
 * http://www.lintcode.com/en/problem/climbing-stairs/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73072
 */
public class ClimbStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n < 1) {
            return 1;
        }
        // 初始化数组
        int[] step = new int[n+1];
        Arrays.fill(step, 1);

        for (int i = 2; i != n + 1; ++i) {
            step[i] = step[i-1] + step[i-2];
        }
        return step[n];
    }
    public int climbStairs2(int n) {
        // write your code here
        if (n < 1) {
            return 1;
        }
        int ret0 = 1, ret1 = 1, ret2 = 1;

        for (int i = 2; i != n + 1; ++i) {
            ret0 = ret1 + ret2;
            ret2 = ret1;
            ret1 = ret0;
        }
        return ret0;
    }
}
