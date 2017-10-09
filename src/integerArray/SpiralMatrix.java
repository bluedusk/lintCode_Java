package integerArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/10/2.
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        // write your code here


        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return res;
        }
        helper(res,matrix,visited,0,0);

        return res;
    }

     static void helper(List<Integer> res,  int[][] matrix, boolean[][] visited, int indexX, int indexY){
        if(res.size() == matrix.length * matrix[0].length){
            return;
        }
        if(visited[indexX][indexY]){
            return;
        }
        // top
        for (int i = indexY; i <= matrix[0].length - indexY - 1; i++) {
            if (visited[indexX][i]){
                break;
            }
            res.add(matrix[indexX][i]);
            visited[indexX][i] = true;
        }
        // right
        for (int i = indexX + 1; i <= matrix.length - indexX - 1; i++) {
            if (visited[i][matrix[0].length - indexY - 1]){
                break;
            }
            res.add(matrix[i][matrix[0].length - indexY - 1]);
            visited[i][matrix[0].length - indexY - 1] = true;
        }

        // bottom
        for (int i = matrix[0].length - indexY - 2; i >= indexY; i--) {
            if (visited[matrix.length - indexX -1][i]){
                break;
            }
            res.add(matrix[matrix.length - indexX - 1][i]);
            visited[matrix.length - indexX - 1][i] = true;
        }

        // left
        for (int i = matrix.length - indexX - 2; i >= indexX; i--) {
            if (visited[i][indexY]){
                break;
            }
            res.add(matrix[i][indexY]);
            visited[i][indexY] = true;
        }
        helper(res,matrix,visited,indexX + 1, indexY + 1);
    }
    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {{1,2,3},{4,5,6},{7,8,9}};
        String str1 = "";


        spiralOrder(AA);
    }
}
