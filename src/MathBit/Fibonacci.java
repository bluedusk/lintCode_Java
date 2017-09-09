package MathBit;

/**
 * Created by Lenovo on 2017/9/5.
 */
public class Fibonacci {

    public int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 1) return 0;
        if (n == 2) return 1;

        int fn = 0, fn1 = 1, fn2 = 0;
        for (int i = 3; i <= n; i++) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }

        return fn;
    }

    public int fibonacci2(int n) {
        if (n < 0) return -1;
        if (n == 1) return 0;
        if (n == 2) return 1;

        int result = fibonacci2(n-1) + fibonacci2(n -2);
        return result;
    }
}
