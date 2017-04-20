package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lenovo on 2017/4/18.
 * http://www.lintcode.com/en/problem/subsets-ii/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73050
 *
 * 回溯法 剪枝
 */
public class SubsetsWithDup {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //sort the array
        Arrays.sort(nums);
        //pos 表示当前位置指针
        subsetsHelper(result, list, nums, 0);

        return result;
    }

    /**
     *
     * @param result  结果数组
     * @param list
     * @param nums
     * @param pos 当前位置指针
     */
    private static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                                      ArrayList<Integer> list, int[] nums, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < nums.length; i++) {
            if (i!=pos && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            //『i + 1』不可误写为『pos + 1』，因为pos用于每次大的循环，i用于内循环； 看pos就知道处于第几层递归
            subsetsHelper(result, list, nums, i + 1);
            // 回溯法，i=pos时，通过回溯，可以回溯到pos
            list.remove(list.size() - 1);
        }
    }
}
