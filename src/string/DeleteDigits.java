package string;

/**
 * Created by Lenovo on 2017/10/5.
 */
public class DeleteDigits {

    public static String DeleteDigits(String A, int k) {
        // write your code here
        StringBuffer sb = new StringBuffer(A);
        int i, j;
        for (i = 0; i < k; i++) {
            for (j = 0; j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1); j++) {}
            sb.delete(j, j + 1);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str1 = "";
        String x = "178542";


        DeleteDigits(x,4);
    }
}
