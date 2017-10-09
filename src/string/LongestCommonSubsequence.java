package string;

/**
 * Created by Lenovo on 2017/9/27.
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
            }
        }
        // print dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
        return f[n][m];
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str2 = "EACB";
        String str1 = "ABCD";

        longestCommonSubsequence(str1,str2);



    }
}
