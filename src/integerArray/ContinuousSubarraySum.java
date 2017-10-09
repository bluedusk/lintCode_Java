package integerArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/10/2.
 *
 * sum[i][j] 代表 i - j的和；
 * sum[0][0] = 0;
 * sum[i][j] = sum[0][j] - sum[0][i]
 */
public class ContinuousSubarraySum {

    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);

        int len = A.length;
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            // sum == 0 前面的可以全部抛弃
            if (sum < 0) {
                sum = A[i];
                start = end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (sum >= ans) {
                ans = sum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        return result;
    }
}
