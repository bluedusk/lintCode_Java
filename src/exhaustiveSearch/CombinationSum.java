package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/24.
 * combinationSum
 *
 * http://www.jiuzhang.com/solutions/combination-sum/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73061
 */
public class CombinationSum {

    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (num == null) return result;

        // 去重
        int[] nums = removeDuplicates(num);
        helper(nums, 0, target, list, result);

        return result;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }
    private void helper(int[] num, int pos, int gap,
                        List<Integer> list, List<List<Integer>> result) {

        if (gap == 0) {
            // add new object for result
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = pos; i < num.length; i++) {
            // cut invalid candidate
            if (gap < num[i]) {
                return;
            }
            list.add(num[i]);
            // 注意是i可以重复使用，因此传入i而不是i+1
            helper(num, i, gap - num[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
