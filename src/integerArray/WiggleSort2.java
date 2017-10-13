package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/10/9.
 */
public class WiggleSort2 {

    // O(n)space
    public void wiggleSort(int[] nums) {
        // Write your code here
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        int n = nums.length, k = (n + 1) / 2, j = n;
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            nums[i] = i%2 == 0 ? tmp[--j] : tmp[--k];
        }
    }

    void  swap(int[] x, int a, int b){
        int tmp;
        tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
