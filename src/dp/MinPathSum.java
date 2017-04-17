package dp;

/**
 * Created by Lenovo on 2017/4/14.
 * http://www.lintcode.com/en/problem/minimum-path-sum/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73069
 * http://www.jiuzhang.com/solutions/minimum-path-sum/
 */
public class MinPathSum {

    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        // 初始化起点，第一行，第一列
        sum[0][0] = grid[0][0];
        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }

    // 递归的实现会超时， 为什么？ 因为没用hashmap存储以前的值，每次都要重新计算 ？
    public int minPathSum2(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;

        return helper(M-1,N-1, grid);
    }

    public int helper(int x, int y, int[][] grid){

        if (0 == x && 0 == y) {
            return grid[0][0];
        }
        if (x==0){
            return helper(0, y-1, grid) + grid[x][y];
        }
        if (y==0){
            return helper(x-1, 0, grid) + grid[x][y];
        }

        return grid[x][y] + Math.min(helper(x - 1, y, grid), helper(x, y - 1, grid));

    }

}
