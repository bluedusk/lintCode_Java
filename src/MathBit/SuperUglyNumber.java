package MathBit;

/**
 * Created by Lenovo on 2017/9/8.
 * http://www.lintcode.com/en/problem/super-ugly-number/
 */
public class SuperUglyNumber {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        // 优先级队列
        int[] times = new int[primes.length];
        int[] uglys = new int[n];
        uglys[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * uglys[times[j]]);
            }
            uglys[i] = min;
            // 已经取值为min的下一轮计算不再出现，如第一轮ugly[0]=1 * primes =  2,7,13,19取2，则time[0]=1表示
            // 第二轮 primes * uglys 从 uglys[1]开始；跳过ugly[0]
            // 第三轮 primes * uglys 从 uglys[1]开始；跳过ugly[1]
            // index = times[i] 表示primes[i]和uglys相乘的时候，prime的第i个值从uglys的哪个index开始；
            for (int j = 0; j < times.length; j++) {
                if (uglys[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }
        return uglys[n - 1];
    }

    public static void main(String[] args){

        nthSuperUglyNumber(5, new int[]{2, 7, 13, 19});

    }}
