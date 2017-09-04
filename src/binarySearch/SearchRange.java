package binarySearch;

/**
 * Created by Lenovo on 2017/9/1.
 * http://www.lintcode.com/en/problem/search-for-a-range/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72968
 */
public class SearchRange {
    /*
 * @param A: an integer sorted array
 * @param target: an integer to be inserted
 * @return: a list of length 2, [index1, index2]
 */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[]{-1, -1};
        if (A == null || A.length == 0) return result;

        int lb = -1, ub = A.length;
        // lower bound
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (A[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        // whether A[lb + 1] == target, check lb + 1 first
        if ((lb + 1 < A.length) && (A[lb + 1] == target)) {
            result[0] = lb + 1;
        } else {
            result[0] = -1;
            result[1] = -1;
            // target is not in the array
            return result;
        }

        // upper bound, since ub >= lb, we do not reset lb
        ub = A.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (A[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        // target must exist in the array
        result[1] = ub - 1;

        return result;
    }
}
