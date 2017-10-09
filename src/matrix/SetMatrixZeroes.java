package matrix;

/**
 * Created by Lenovo on 2017/10/7.
 *
 * 可以先找出所有的0，这样可以找出所有需要被设置为0的所有行和列， 但这样不是in place
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean empty_row0 = false;
        boolean empty_col0 = false;
        // - 先扫描第一行第一列，如果有0，则将各自的flag设置为true
        // 第一行
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }
        // 第一列
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }
        //- 然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
        for(int i = 1; i < rows; i++) {
            for(int j =1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // - 再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
        for(int i = 1; i<rows; i++) {
            for (int j=1; j< cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        // - 最后根据第一行第一列的flag来更新第一行第一列

        if(empty_row0){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }

        if(empty_col0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }

    }
}
