package binarySearch;

/**
 * Created by openworld on 2017/9/3.
 * http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/
 *
 * 题解：
 * http://www.cnblogs.com/yuzhangcmu/p/4138184.html
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        // 奇数个元素
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        // 偶数个元素
        return (
                findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        // Base Case, pay attention. 在这里必须要退出。因为k = 1的时候，不可能再分了。
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        // -1是因为索引本身是从0开始的。而前k大元素含有k个元素。
        int mid = k / 2 - 1;

        int A_key = A_start + mid < A.length
                ? A[A_start + mid]
                : Integer.MAX_VALUE;
        int B_key = B_start + mid < B.length
                ? B[B_start + mid]
                : Integer.MAX_VALUE;

        // 因为丢弃了k / 2个元素
        int kNew = k - k / 2;

        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, kNew);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, kNew);
        }
    }

}
