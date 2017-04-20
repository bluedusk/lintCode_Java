package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/19.
 * http://www.jiuzhang.com/solutions/permutation-sequence/
 * 九章的很难懂
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73058
 *
 *
 *
 1. 以某一数字开头的排列有(n-1)! 个。 例如： 123， 132， 以1开头的是 2！个
 2. 所以第一位数字就可以用 （k-1） / (n-1)!  来确定 .这里K-1的原因是，序列号我们应从0开始计算，否则在边界时无法计算。
 3. 第二位数字。假设前面取余后为m，则第二位数字是 第 m/(n-2)! 个未使用的数字。
 4. 不断重复2，3，取余并且对(n-k)!进行除法，直至计算完毕
 */
public class PermutationSequence {

    /**
     * @param n: n
     * @param k: the kth permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        // get factorial array
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        // generate nums 1 to n
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        // get the permutation digit
        StringBuilder sb = new StringBuilder();
        // 每一个循环确定一位
        for (int i = 0; i < n; i++) {
            // k begins from 1, so (1, 2) is a group
            int rank = (k - 1) / fact[n - i - 1];
            k = (k - 1) % fact[n - i - 1] + 1;
            // ajust the mapping of rank to num
            sb.append(nums.get(rank));
            nums.remove(nums.get(rank));
        }

        return sb.toString();
    }

}
