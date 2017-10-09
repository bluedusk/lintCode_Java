package integerArray;

/**
 * Created by Lenovo on 2017/10/5.
 */
public class MatrixZigzagTraversal {

    public static int[] printZMatrix(int[][] matrix) {
        // write your code here
        int x, y, dx, dy, count, m, n;
        x = y = 0;
        count = 1;
        //
        dx = -1; dy = 1;
        m = matrix.length;
        n = matrix[0].length;
        int[] z = new int[m*n];
        z[0] = matrix[0][0];

        while (count<m*n) {

            // 不在边缘，那么要么向右上
            if (x+dx>=0 && y+dy>=0 && x+dx<m && y+dy<n) {
                x += dx; y += dy;
            }
            else if (dx==-1 && dy ==1) {
                if (y+1<n){
                    ++y;
                } else{
                    ++x;
                }
                dx = 1; dy = -1;
            }
            else {
                if (x+1<m){
                    ++x;
                } else {
                    ++y;
                }
                dx = -1; dy = 1;
            }
            z[count] = matrix[x][y];
            ++count;
        }
        return z;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {{1, 2,  3,  4},{5, 6,  7,  8}, {9,10, 11, 12}};
        String str1 = "";

        printZMatrix(AA);

    }
}
