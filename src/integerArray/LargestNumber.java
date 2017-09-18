package integerArray;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Created by Lenovo on 2017/9/15.
 */
public class LargestNumber {
    // 注意几种情况
    // 0; 0,0; 99,9;
    public static String largestNumber(int[] nums) {
        // write your code here
        ArrayList<String> list = new ArrayList<>();
        for (int i : nums) {
            list.add(Integer.toString(i));
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // 解决 98会排在9前面的问题
                 return (s2+s1).compareTo(s1+s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).toString();
            sb.append(s);
        }
        // 解决 00的问题，将字符串前面所有的0变为一个0；
        return sb.toString().replaceAll("^(0+)", "0");
    }
    public static void main(String[] args){
        String[] s = {};
        int[] A = {1, 20, 23, 4, 8};
        int[] A1 = {41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
        int[][] AA = {};
        largestNumber(A1);

    }

}
