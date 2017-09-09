package MathBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openworld on 2017/9/4.
 */
public class SingleNumber3 {

    public List<Integer> singleNumberIII(int[] A) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        if (A == null || A.length == 0) return nums;

        int x1xorx2 = 0;
        for (int i : A) {
            x1xorx2 ^= i;
        }

        // get the last 1 bit of x1xorx2, e.g. 1010 ==> 0010
        // 取最后一个1
        // 1111111
        // 1111110
        // 1111110
        // 0000001

        // 1000
        // 0111
        // 0000
        // 1000

        // 1010
        // 1001
        // 1000
        // 0010
        int last1Bit = x1xorx2 - (x1xorx2 & (x1xorx2 - 1));
        int single1 = 0, single2 = 0;
        for (int i : A) {
            if ((last1Bit & i) == 0) {
                single1 ^= i;
            } else {
                single2 ^= i;
            }
        }

        nums.add(single1);
        nums.add(single2);
        return nums;
    }

    public static void main(String[] args){

        int a = 1;
        int b = 2;

        int c = 10;

//        System.out.println(c);
        int last1Bit = c - (c & (c - 1));

        // 1010 --- 1001


        System.out.println(Integer.valueOf("1010",2).toString());//

        System.out.println(last1Bit);//
        System.out.println(Integer.toBinaryString(last1Bit));//结果是10

        System.out.println(Integer.toBinaryString(a));//结果是10
        System.out.println(Integer.toBinaryString(b));//结果是10
        System.out.println(Integer.toBinaryString(c));//结果是10
        System.out.println(Integer.toBinaryString(14));//结果是10

    }

}
