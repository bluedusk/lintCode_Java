package MathBit;

/**
 * Created by Lenovo on 2017/9/8.
 */
public class Pow {

    public double myPow(double x, int n) {
        // Write your code here
        if (n < 0) return 1 / power(x, -n);
        return power(x, n);
    }

    public double power(double x, int n){
        if (n == 0) return 1;

        double half = power(x, n / 2);
        if (n % 2 == 0) return half * half;
        return x * half * half;
    }
    //这道题还有迭代的解法，我们让i初始化为n，然后看i是否是2的倍数，
    // 是的话x乘以自己，否则res乘以x，i每次循环缩小一半，直到为0停止循环。
    // 最后看n的正负，如果为负，返回其倒数，参见代码如下：
    public double myPow1(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

}
