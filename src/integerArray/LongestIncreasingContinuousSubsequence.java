package integerArray;

/**
 * Created by Lenovo on 2017/10/3.
 */
public class LongestIncreasingContinuousSubsequence {


    public static int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int result1 = 1;
        int max = 1;

        int cur = 1;
        while(cur < A.length){
            if(A[cur - 1] < A[cur]){
                result1 ++;
            }
            else{
                max = Math.max(result1, max);
                result1 = 1;
            }
            cur ++;
        }
        // 处理最后一位的问题，比如 51234
        max = Math.max(result1, max);


        cur = 1;
        result1 = 1;
        while(cur < A.length){
            if(A[cur - 1] > A[cur]){
                result1 ++;
            }
            else{
                max = Math.max(max, result1);
                result1 = 1;
            }
            cur ++;
        }
        max = Math.max(result1, max);

        return max;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {5,1,2,3,4};
        int[][] AA = {};
        String str1 = "";
        longestIncreasingContinuousSubsequence(A);


    }
}
