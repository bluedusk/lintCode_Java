package array;

/**
 * Created by Lenovo on 2017/9/30.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        // write your code here
        int m = board.length;
        int n = board[0].length;
        boolean[][] accessed = new boolean[m][n];
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(board, word, accessed, i,j)){
                    return true;
                }
            }
        }

        return false;

    }

    // 四面八方搜索
    static boolean dfs(char[][] board, String target, boolean[][] accessed, int x, int y){
        if(target.isEmpty()){
            return true;
        }
        // 越界返回
        if(!inbound(accessed,x,y)){
            return false;
        }
        // 不可重复使用
        if(accessed[x][y]){
            return false;
        }
        if (board[x][y] != target.charAt(0)){
            return false;
        }
        accessed[x][y] = true;
        boolean res =
        dfs(board,target.substring(1,target.length()),accessed,x + 1, y)
        || dfs(board,target.substring(1,target.length()),accessed,x - 1, y)
        || dfs(board,target.substring(1,target.length()),accessed,x, y + 1)
        || dfs(board,target.substring(1,target.length()),accessed,x, y - 1);

        // 一定一定要注意这个设置，当走到这一步的时候实际上是后退了，因此要设置为false
        accessed[x][y] = false;
        return res;

    }

    static boolean inbound(boolean[][] board,int x, int y){
        int m = board.length;
        int n = board[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str1 = "ABCESEEEFS";

        char[][] cc = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

        exist(cc,str1);
    }
}
