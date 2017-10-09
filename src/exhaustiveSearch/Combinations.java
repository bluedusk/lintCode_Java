package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/21.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73060
 * http://www.lintcode.com/en/problem/combinations/
 */
public class Combinations {

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public static List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>() ;

        if (n <= 0 || k <= 0) return result;
        helper(n,k,1,list,result);
        return result;
    }

    public static void helper(int n, int k, int pos, List<Integer> list, List<List<Integer>> result){
        if (list.size() == k){
            // 注意！这里是添加一份拷贝，不是list
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = pos; i <= n; i++ ){
            list.add(i);
            helper(n,k,i+1,list,result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str1 = "";


    }
}
