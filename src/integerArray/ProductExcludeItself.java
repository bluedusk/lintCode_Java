package integerArray;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lenovo on 2017/6/13.
 * http://www.lintcode.com/en/problem/product-of-array-exclude-itself/
 */
public class ProductExcludeItself {

    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int size = A.size();

        ArrayList<Long> left = new ArrayList<Long>(Collections.nCopies(size,new Long(1)));
        ArrayList<Long> right = new ArrayList<Long>(Collections.nCopies(size,new Long(1)));
        ArrayList<Long> result = new ArrayList<Long>();

        for (int i = 1; i < size; i++) {
            left.set(i,left.get(i - 1) * A.get(i-1));
            right.set(size-i-1,A.get(size-i) * right.get(size-i));
        }
        for (int i = 0; i < size; i++) {
            result.add(i, left.get(i)*right.get(i));
        }
        return result;
    }
    // solution 2
    public static ArrayList<Long> productExcludeItself2(ArrayList<Integer> A) {
        // write your code
        int size = A.size();

        ArrayList<Long> result = new ArrayList<Long>(Collections.nCopies(size,new Long(1)));


        for (int i = 1; i < size; i++) {
            result.set(i,result.get(i - 1) * A.get(i-1));
        }
        long temp = 1;
        for (int i = size - 1; i >= 0; --i) {
            result.set(i,result.get(i) * temp);
            temp *= A.get(i);
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        productExcludeItself2(nums);
    }
}
