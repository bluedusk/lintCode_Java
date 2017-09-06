package MathBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/5.
 */
public class NumbersByRecursion {

    public static List<Integer> numbersByRecursion(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) {
            return result;
        }
        helper(n, result);
        return result;
    }

    private static void helper(int n, List<Integer> ret) {
        if (n == 0) return;
        helper(n - 1, ret);
        // current base such as 10, 20, 30...
        int base = (int)Math.pow(10, n - 1);
        // get List size before for loop
        int size = ret.size();
        for (int i = 1; i < 10; i++) {
            // add 10, 100, 1000...
            ret.add(i * base);
            for (int j = 0; j < size; j++) {
                // add 11, 12, 13...
                ret.add(ret.get(j) + base * i);
            }
        }
    }

    public static void main(String[] args){
        numbersByRecursion(2);
    }

}
