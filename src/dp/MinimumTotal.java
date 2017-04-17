package dp;

/**
 * Created by Lenovo on 2017/4/13.
 * http://www.lintcode.com/en/problem/triangle/
 * http://www.jiuzhang.com/solutions/triangle/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73066
 *
 * 实现方法比较多，上面讲得很好。
 * 递归遍历
 * 分治法
 * hashmap保存
 * 动态规划
 * */
public class MinimumTotal {

    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize
        // 人字形区域的值初始化，联想到UniquePath的初始化， UniquePath就像矩形，这个是三角形
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        // top down
        // 根据DP的公式从上到下扫描
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }

        // answer
        // 求得的answer是triangle[0][0]到triangle[n-1]行内所有元素的f值
        // 得到min需要对最后一行进行遍历一次
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }


}
