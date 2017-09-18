package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by openworld on 2017/9/16.
 */
public class NQueens {

    /*
 * @param n: The number of queens
 * @return: All distinct solutions
 */
    static List<List<String>>  solveNQueens(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private static void search(List<List<String>> results,
                        List<Integer> cols,
                        int n) {
        // 矩阵已满则加入结果集
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            // 在当前结果集cols的基础上，如果新的一行Q放在colIndex的位置是否满足？
            if (!isValid(cols, colIndex)) {
                continue;
            }
            // 满足则加进去
            cols.add(colIndex);
            search(results, cols, n);
            // 如果cols没到n，但是colIIndex已经到了n，说明基于I当前的cols,colIndex取什么值都不合适
            // 这时候需要返回上一行，试探上一行Q的其他取值，也就是放在后一个位置
            // 以此类推，之后cols到了n，说明形成了一个合理的结果集
            cols.remove(cols.size() - 1);
        }
    }

    // 根据cols填充，如5皇后；cos.get(0)==1; 则第0行Q放在1的位置：  .Q...
    private static List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<String>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    // column : 当前行想放在第几列
    // cols : 已有所有行Queen放在第几列的list
    private static boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Date begin =new Date();
        solveNQueens(17);
        Date end =new Date();
        System.out.println("解决4皇后问题，用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果：");
    }

}
