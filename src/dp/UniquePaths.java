package dp;

/**
 * Created by Lenovo on 2017/4/13.
 * http://www.lintcode.com/en/problem/unique-paths/
 *
 */
public class UniquePaths {

    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     *
     * 题目要求：给定m x n矩阵，求左上角到右下角的路径总数，每次只能向左或者向右前进。按照动态规划中矩阵类问题的通用方法：

        1.State: f[m][n] 从起点到坐标(m,n)的路径数目
        2.Function: f[m][n] = f[m-1][n] + f[m][n-1] 分析终点与左边及右边节点的路径数，发现从左边或者右边到达终点的路径一定不会重合，相加即为唯一的路径总数
        3.Initialization: f[i][j] = 1, 到矩阵中任一节点均至少有一条路径，其实关键之处在于给第0行和第0列初始化，免去了单独遍历第0行和第0列进行初始化
        4.Answer: f[m - 1][n - 1]
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 || n == 0) {
            return 1;
        }
        // 初始化sum数组，第0行和第0列初始化
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        // 从1开始
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }
}
