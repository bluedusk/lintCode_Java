package binarySearch;

/**
 * Created by Lenovo on 2017/9/1.
 * http://lintcode.com/en/problem/search-a-2d-matrix-ii/
 */
public class SearchMatrix2 {

    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     *
     * 右上角开始搜索
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here

        int occurrence = 0;
        if (matrix == null || matrix.length == 0 || matrix[0] == null ) {
            return occurrence;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                occurrence++;
                col--;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return occurrence;
    }
}
