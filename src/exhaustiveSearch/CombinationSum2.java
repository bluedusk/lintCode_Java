package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/24.
 * combinationSum2
 */
public class CombinationSum2 {

    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (num == null) return result;

        Arrays.sort(num);
        helper(num, 0, target, list, result);

        return result;
    }
    private void helper(int[] nums, int pos, int gap,
                        List<Integer> list, List<List<Integer>> result) {

        if (gap == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            // ensure only the first same num is chosen, remove duplicate list
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            // cut invalid num
            if (gap < nums[i]) {
                return;
            }
            list.add(nums[i]);
            // i + 1 ==> only be used once
            helper(nums, i + 1, gap - nums[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
