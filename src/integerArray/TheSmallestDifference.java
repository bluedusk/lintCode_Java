package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/9/27.
 */
public class TheSmallestDifference {
    // 如果n*n时间很好做，题目要求nlogn
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        int result = Integer.MAX_VALUE;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;

        while(i < A.length && j < B.length){

            result = Math.min(Math.abs(A[i] - B[j]),result);
            if(result == 0){
                return 0;
            }
            if(A[i] > B[j]){
                j++;
            }
            else{
                i++;
            }
        }

        return result;
    }


}
