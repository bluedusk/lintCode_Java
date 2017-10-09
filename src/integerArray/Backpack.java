package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/9/28.
 */
public class Backpack {
    // 二维数组
    public static int backPack(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                // 默认不放入i
                f[i][j] = f[i - 1][j];
                // 如果前 i−1 个物品能否取出一些体积和为 j − A[i-1] 的背包
                if (j >= A[i-1] && f[i-1][j - A[i-1]]) {
                    f[i][j] = true; // 前i个数能组成j
                }
            } // for j
        } // for i

        for (int i = 0; i < A.length + 1 ; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(f[i][j] ? 1 : 0);
            }
            System.out.println();

        }

        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }

        return 0;
    }
    public static void main(String[] args){
        String[] s = {};
        int[] A = {2, 3, 5, 7};
        int[][] AA = {};
        String str1 = "";

        backPack(11,A);

    }
    // 一维数组
    public int backPack2(int m, int[] A) {
        if (A.length==0) return 0;

        int len = A.length;
        boolean[] size = new boolean[m+1];
        Arrays.fill(size,false);
        size[0] = true;
        for (int i=1;i<=len;i++)
            for (int j=m;j>=0;j--){
                if (j-A[i-1]>=0 && size[j-A[i-1]])
                    size[j] = size[j-A[i-1]];
            }

        for (int i=m; i>=0;i--)
            if (size[i]) return i;

        return 0;
    }
}
