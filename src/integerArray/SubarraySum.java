package integerArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lenovo on 2017/6/12.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72948
 * http://www.lintcode.com/en/problem/subarray-sum/
 */
public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here

        int len = nums.length;

        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            // 如果sum出现过，说明从出现位置 map.get(sum)后一位到i这个subArray的sum为0；
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }

            map.put(sum, i);
        }

        return ans;

    }
}
