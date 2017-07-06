package integerArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/6/14.
 * http://www.lintcode.com/en/problem/two-sum/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72955
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[]{0, 0};

        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int index1 = 0, index2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (hashmap.containsKey(target - numbers[i])) {
                index1 = hashmap.get(target - numbers[i]);
                index2 = i;
                return new int[]{1 + index1, 1 + index2};
            } else {
                hashmap.put(numbers[i], i);
            }
        }

        return new int[]{0, 0};
    }

    // solution2 ： 排序+双指针求2sum方式；

}
