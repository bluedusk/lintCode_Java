package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Lenovo on 2017/3/16.
 * http://www.lintcode.com/en/problem/subsets/
 * http://www.jiuzhang.com/solutions/subsets/
 * HARD
 */
public class Subsets {

    /**
     * @param num: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //sort the array
        Arrays.sort(num);
        //pos 表示当前位置指针
        subsetsHelper(result, list, num, 0);

        return result;
    }

    /**
     *
     * @param result  结果数组
     * @param list
     * @param num
     * @param pos 当前位置指针
     */
    private static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                                      ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {

            list.add(num[i]);
            //『i + 1』不可误写为『pos + 1』，因为pos用于每次大的循环，i用于内循环； 看pos就知道处于第几层递归
            subsetsHelper(result, list, num, i + 1);
            // 回溯法，i=pos时，通过回溯，可以回溯到pos
            list.remove(list.size() - 1);
        }
    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     *
     * non-recursive version
     */
    public static ArrayList<ArrayList<Integer>> subsets2(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args){
        int[] hi = {1,2,3};

        /*
        *数组添加顺序
        * []
        * 1
        * 12
        * 123
        * 13
        * 2
        * 23
        * 3
        *
        * */

        ArrayList<ArrayList<Integer>> rst = subsets(hi);
        ArrayList<ArrayList<Integer>> rst2 = subsets2(hi);

        int[] hi1 = {1,2,3};

    }


}
