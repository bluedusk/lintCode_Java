package integerArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/10/1.
 */
public class KSum2 {
    List<List<Integer>> ans;
    public void dfs(int A[], int K, int target, int index, List<Integer> tans)
    {

        if(K == 0 && target == 0) {
            // 注意需要new ArrayList
            ans.add(new ArrayList<Integer>(tans));
            return ;
        }
        if(K < 0 || target < 0 || index < 0)
            return ;
        dfs(A, K, target, index - 1, tans);
        // 将A[index]放入
        tans.add(A[index]);
        dfs(A, K  - 1, target - A[index], index - 1, tans);
        // return 后需要删掉最后一个元素，所有dfs都如此
        tans.remove(tans.size() - 1);

    }

    public List<List<Integer>> kSumII(int A[], int K, int target) {
        ans = new ArrayList<List<Integer>>();
        List<Integer> tans = new ArrayList<Integer>();
        dfs(A, K, target, A.length - 1, tans);
        return ans;
    }
}
