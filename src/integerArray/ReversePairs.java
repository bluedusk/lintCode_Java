package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/10/11.
 * https://zhengyang2015.gitbooks.io/lintcode/reverse_pairs_532.html
 */
public class ReversePairs {


    public long reversePairs(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        int sum = 0;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid+1, end);
        sum += merge(A, start, mid, end);
        return sum;
    }

    private int merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        int sum = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
                sum += mid - leftIndex + 1;
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }

        return sum;
    }


    ///////////////////////////
    public class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length-1);
        }
        private int mergeSort(int[] nums, int s, int e){
            if(s>=e) return 0;
            int mid = s + (e-s)/2;
            int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
            for(int i = s, j = mid+1; i<=mid; i++){
                while(j<=e && nums[i]/2.0 > nums[j]) j++;
                cnt += j-(mid+1);
            }
            Arrays.sort(nums, s, e+1);
            return cnt;
        }
    }
}
