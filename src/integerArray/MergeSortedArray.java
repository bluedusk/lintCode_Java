package integerArray;

/**
 * Created by Lenovo on 2017/8/31.
 * http://www.lintcode.com/en/problem/merge-sorted-array/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72960
 */
public class MergeSortedArray {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        if (A == null || B == null) return;

        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[index] = A[m - 1];
                m--;
            } else {
                A[index] = B[n - 1];
                n--;
            }
            index--;
        }

        // B has elements left
        while (n > 0) {
            A[index] = B[n - 1];
            n--;
            index--;
        }

    }
}
