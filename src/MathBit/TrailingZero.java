package MathBit;

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

    // 递归
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return -1;
        } else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }
    public static void main(String[] args) {
        // write your code here

        System.out.println(trailingZeros(11));

    }


}
