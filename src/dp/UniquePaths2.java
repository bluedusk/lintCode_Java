package dp;

/**
 * Created by Lenovo on 2017/4/13.
 * http://www.lintcode.com/en/problem/unique-paths-ii/
 * http://www.jiuzhang.com/solutions/unique-paths-ii/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73071
 */
public class UniquePaths2 {

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     *
     * 在上题的基础上加了obstacal这么一个限制条件，那么也就意味着凡是遇到障碍点，其路径数马上变为0，需要注意的是初始化环节和上题有较大不同
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];

        for (int i=0; i<m; i++){
            if (obstacleGrid[i][0] == 0){
                sum[i][0] = 1;
            }
            else{
                //初始化第0行和第0列时，未考虑到若第0行/列有一个坐标出现障碍物，则当前行/列后的元素路径数均为0
                break;
            }
        }

        for (int i=0; i<n; i++){
            if (obstacleGrid[i][0] == 0){
                sum[0][i] = 1;
            }
            else{
                break;
            }
        }

        for (int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if (obstacleGrid[i][0] == 1){
                    sum[i][j] = 0;
                }
                else{
                    sum[i][j] = sum[i-1][j] + sum[i][j-1];
                }
            }
        }
        return sum[m-1][n-1];
    }
}
