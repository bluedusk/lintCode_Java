package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/3/14.
 * http://www.lintcode.com/en/problem/permutations/
 * http://www.jiuzhang.com/solutions/permutations/
 * Hard
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }

        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, nums);
        return rst;
    }

    // 把list中没有的nums中有的数字加入nums中；当全部数字加入，则返回
    public static void  helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
        // 如果一个list加满了，也就生成了一个排列
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        // 对于nums[i]依次加入list
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            // nums[i]加入后
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args){
        int[] hi = {1,2,3,4};

        /*
        这种情况为例
        helper(rst, [1,2], [1,2,3,4])
        * i=0, continue
        * i=1, continue
        * i=2, list = [123] 进入下一层helper,下一层helper返回 1234, 返回上一个循环；i++
        * i=3， list = [124] 进入下一层helper，下一层helper经过三个continue返回1243返回循环 i++ 循环结束
        * list[12]删除尾部2, 上层循环继续；
        * 上层i = 2; list[13]
        * */

        List<List<Integer>> rst = permute(hi);

        int[] hi1 = {1,2,3};

    }
}
