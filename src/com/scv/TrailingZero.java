package com.scv;

/**
 * Created by Lenovo on 2017/3/2.
 * http://www.lintcode.com/zh-cn/problem/trailing-zeros/
 * Status: DONE
 */
public class TrailingZero {

    /*
   * param n: As desciption
   * return: An integer, denote the number of trailing zeros in n!
   * 阶乘有个特点,一个5会产生一个0
   */
    public static long trailingZeros(long n) {
        // write your code here
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        // write your code here

        System.out.println(trailingZeros(100));

    }


}
