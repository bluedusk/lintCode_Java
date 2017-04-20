package exhaustiveSearch;

/**
 * Created by Lenovo on 2017/4/17.
 * http://www.lintcode.com/en/problem/permutation-index/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73056
 * http://www.jiuzhang.com/solutions/permutation-index/
 */
public class PermutationIndex {


    /**
     * @param A an integer array
     * @return a long integer
     */
    public static long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) return 0;

        long index = 1;
        long factor = 1; // 阶乘
        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) rank++;
            }
            // 如果ai > aj 则表示 ij对换后的所有组合都比当前组合小，那么这种组合有多少？
            // rank 表示i后面有几个j比i大，表示可以交换几次
            // factor 表示每交换一次，产生多少次比A小的排列组合
            // A = [5,2,1,3,4] 比如当 i=5时，后面数字都比5小；后面有4个数，能产生factor = 4！=24个组合
            // 每个数字和5交换的组合都比A小，有rank=4个数字；
            // 因此在i=5这层循环中，index需要增加 4*24个
            index += rank * factor;
            factor *= (A.length - i);
        }

        return index;
    }

    public static void main(String[] args){
        int[] array = {5,2,1,3,4};
        permutationIndex(array);
    }


}
