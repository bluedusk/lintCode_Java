package com.scv;

/**
 * Created by openworld on 17/3/5.
 * http://www.lintcode.com/zh-cn/problem/merge-two-sorted-arrays/
 */
public class MergeSortedArray {


    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here

        if (A == null || B == null) {
            return null;
        }

        int[] result = new int[A.length + B.length];
        int i = 0, j = 0, index = 0;
        // A或者B全部输入C
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                result[index++] = A[i++];
            } else {
                result[index++] = B[j++];
            }
        }
        // 如果A没完成扫描，B完成了，则输入A余下的
        while (i < A.length) {
            result[index++] = A[i++];
        }
        // 如果B没完成扫描，A完成了，则输入B余下的
        while (j < B.length) {
            result[index++] = B[j++];
        }

        return result;
    }
}
