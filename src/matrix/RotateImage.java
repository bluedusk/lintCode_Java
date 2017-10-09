package matrix;

/**
 * Created by Lenovo on 2017/10/6.
 * 有几种解法，参见：
 * http://www.cnblogs.com/grandyang/p/4389572.html
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        for (int r = 0; r < (n + 1) / 2; r++) {
            for (int c = 0; c < n / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n - 1 - c][r];
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
                matrix[c][n - 1 - r] = tmp;
            }
        }
    }
}
