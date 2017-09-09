package MathBit;

import java.util.HashSet;

/**
 * Created by openworld on 2017/9/7.
 */
public class HappyNumber {

/*
 * @param n: An integer
 * @return: true if this is a happy number or false
 */
    public boolean isHappy(int n) {
        // write your code here


        HashSet<Integer> hash = new HashSet<Integer>();

        while (n != 1) {
            int t = 0;
            while (n!=0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            n = t;
            if (hash.contains(n)) break;
            else hash.add(n);
        }
        return n == 1;
    }

}
