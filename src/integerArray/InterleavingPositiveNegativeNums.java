package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/10/7.
 */
public class InterleavingPositiveNegativeNums {


    // solution 1 : 太难懂了而且用了extra space
    int[] subfun(int[] A,int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
        }
        if(len % 2 == 1)
            ans[len - 1] = A[len / 2];
        return ans;
    }
    public void rerange(int[] A) {
        int[] Ap = new int[A.length];
        int totp = 0;
        int totm = 0;
        int[] Am = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++)
            if(A[i] > 0)
            {
                Ap[totp] = A[i];
                totp += 1;
            }
            else
            {
                Am[totm] = A[i];
                totm += 1;
            }
        if(totp > totm)
            tmp = subfun(Ap, Am, A.length);
        else
            tmp = subfun(Am, Ap, A.length);
        for (int i = 0; i < tmp.length; ++i)
            A[i] = tmp[i];
    }

    // solution 2:
    public void rerange1(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        // sort 了还算in place吗 ？
        Arrays.sort(A);
        int count = 0;
        // 计算正负数谁多
        for (int num : A){
            count += num >= 0 ? 1 : -1;
        }
        int start = 0;
        int end = A.length - 1;
        // 负数多start前进
        if (count < 0) {
            start++;
        }
        // 正数多end后退
        else if (count > 0){
            end--;
        }

        while (start < end) {
            if (A[start] < 0 && A[end] >= 0) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
            }
            start += 2;
            end -= 2;
        }
    }
}
