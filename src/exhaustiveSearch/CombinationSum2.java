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
