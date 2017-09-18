package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/15.
 * http://www.jiuzhang.com/solution/permutations-ii
 */
public class Permutations2 {

    public static void main(String[] args){
        String[] s = {};
        int[] A = {1,2,2};
        int[][] AA = {};
        permuteUnique(A);

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums == null) {
            return results;
        }

        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];

        helper(results, list, visited, nums);
        return results;
    }


    public static void helper(ArrayList<List<Integer>> results,
                       ArrayList<Integer> list, int[] visited, int[] nums) {

        if(list.size() == nums.length) {
            // 这里应该可以判断，但是效率低
            results.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
                    && visited[i-1] == 0)){
                continue;
            }
            /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            */
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
