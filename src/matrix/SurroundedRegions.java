package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lenovo on 2017/10/11.
 * http://www.jiuzhang.com/solution/surrounded-regions/
 */
public class SurroundedRegions {

    // version 1 : stackover flow
    public void surroundedRegions(char[][] grid) {

        // 异常处理
        m = grid.length;
        if (m == 0) {
            return;
        }
        n = grid[0].length;
        if (n == 0) {
            return;
        }

        // 将所有的边缘O设置为Y
        int nums = 0;
        for (int i = 0; i < n ; i++) {
            if (grid[0][i] == 'O') {
                dfs(grid, 0, i,'O','Y');
            }
            if (grid[m-1][i] == 'O') {
                dfs(grid, m-1, i,'O','Y');
            }
        }
        for (int i = 0; i < m ; i++) {
            if (grid[i][0] == 'O') {
                dfs(grid, i, 0,'O','Y');
            }
            if (grid[i][n-1] == 'O') {
                dfs(grid, i, n-1,'O','Y');
            }
        }

        // 将中间的O替换为X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O') {
                    dfs(grid, i, j,'O','X');
                }
            }
        }

        // 将边缘的Y替换回O
        for (int i = 0; i < n ; i++) {
            if (grid[0][i] == 'Y') {
                dfs(grid, 0, i,'Y','O');
            }
            if (grid[m-1][i] == 'Y') {
                dfs(grid, m-1, i,'Y','O');
            }
        }
        for (int i = 0; i < m ; i++) {
            if (grid[i][0] == 'Y') {
                dfs(grid, i, 0,'Y','O');
            }
            if (grid[i][n-1] == 'Y') {
                dfs(grid, i, n-1,'Y','O');
            }
        }


    }

    private void dfs(char[][] grid, int i, int j, char c1, char c2 ) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == c1) {
            grid[i][j] = c2;
            dfs(grid, i - 1, j,c1,c2);
            dfs(grid, i + 1, j,c1,c2);
            dfs(grid, i, j - 1,c1,c2);
            dfs(grid, i, j + 1,c1,c2);
        }
    }

    private int m, n;

    // version 2:
    public void surroundedRegions1(char[][] board) {
        // Write your code here
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            bfs(board, 0, j);
            bfs(board, n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void bfs(char[][] board, int sx, int sy) {
        if (board[sx][sy] != 'O') {
            return;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(sx);
        qy.offer(sy);
        board[sx][sy] = 'W';                          // 'W' ->  Water
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m
                        && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W';              // 'W' ->  Water
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
    }
}
