package com.scv;

/**
 * Created by Lenovo on 2017/3/2.
 * http://www.lintcode.com/zh-cn/problem/digit-counts/
 */
public class DigitCounts {

    /*
     * param k : As description.
     * param n : As description.
     * return: How many k's between 0 and n.
     */

    public static int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k); // 对每一个i数求k出现了几次，比如11中1出现了2次
        }
        return cnt;
    }
    // 每个数i里面有几个k
    // 比如11里面有2个1
    public static int singleCount(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) { // 取最后一位，如果最后一位等于k, 则count++
                cnt++;
            }
            i = i / 10; // 删除最后一位，循环继续
        }
        return cnt;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(1011%10);
        System.out.println(1011/10);
        System.out.println(singleCount(1011,1));
        System.out.println(digitCounts(1,15));

    }
}
