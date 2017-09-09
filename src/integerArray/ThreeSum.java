package integerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/6/15.
 * http://www.lintcode.com/en/problem/3sum/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72956
 */

public class ThreeSum {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(nums == null || nums.length < 3){
            return result;
        }
        // 需要排序，否则没法判定unique
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            ArrayList<ArrayList<Integer>> twoSumArray = twoSum(nums,0-nums[i],i+1);
            // 找到结果
            if(twoSumArray.size()>0){
                for (ArrayList<Integer> item:twoSumArray) {
                    item.add(0,nums[i]); // 保证顺序，答案需要升续的
                    if(!result.contains(item)){
                        result.add(item);
                    }
                }

            }
        }


        return result;
    }

    public static ArrayList<ArrayList<Integer>> twoSum(int[] numbers, int target, int start) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        // 已到达最后一位
        if(numbers.length - start < 2){
            return result;
        }
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = start; i < numbers.length; i++) {
            if (hashmap.containsKey(target - numbers[i])) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                // 找到一个2sum
                item.add(numbers[hashmap.get(target - numbers[i])]);
                item.add(numbers[i]);
                if(!result.contains(item)){
                    result.add(item);
                }
            } else {
                hashmap.put(numbers[i], i);
            }
        }
        // 2sum + A[i] = 0 的集合
        return result;
    }

    public static void main(String[] args){
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> item1 = new ArrayList<>();
//        item1.add(1);item1.add(1);
//        ArrayList<Integer> item2 = new ArrayList<>();
//        item2.add(1);item2.add(1);
//
//        result.add(item1);
//        result.contains(item1);
//        result.contains(item2);

        int[] nums = {-1,0, 1 ,2, -1 ,-4};
        threeSum(nums);
    }
}
