package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/9/27.
 * nlogn
 * n
 * 两种解法
 */
public class WiggleSort {

    public void wiggleSort1(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        // 123456789  132 547 69
        for (int i = 2; i < nums.length; i += 2) {
            swap(nums,i,i - 1);
        }
    }

    public void wiggleSort(int[] nums) {
        // Write your code here
        for(int i=1; i<nums.length; i++) {
            if((i%2==1 && (nums[i] < nums[i-1]) ||
                    (i%2==0) && (nums[i] > nums[i-1]))) {
                swap(nums, i-1, i);
            }
        }
    }




    void  swap(int[] x, int a, int b){
        int tmp;
        tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {1,2};
        int[][] AA = {};
        String str1 = "";
        int a = 1;
        int b = 2;

//        swap(A,0,1);
        System.out.print(A[0]);
        System.out.print(A[1]);

    }
}
