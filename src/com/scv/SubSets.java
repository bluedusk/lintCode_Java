package com.scv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lenovo on 2017/3/16.
 * http://www.lintcode.com/en/problem/subsets/
 * http://www.jiuzhang.com/solutions/subsets/
 * HARD
 */
public class SubSets {

    /**
     * @param num: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        // sort the array
        Arrays.sort(num);
        //pos 表示当前位置指针
        subsetsHelper(result, list, num, 0);

        return result;
    }

    
    private static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {

            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] hi = {1,2,3};

        /*
        *数组添加顺序
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

        int[] hi1 = {1,2,3};

    }


}
