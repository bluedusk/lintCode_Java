package integerArray;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Lenovo on 2017/10/3.
 */
public class KthSmallestNumberInSortedMatrix {
    class Pair {
        public int x, y, val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // 这两个数组控制元素的向右，向下移动
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        // 是否添加过
        boolean[][] hash = new boolean[n][m];
        // 堆排序思想，最小堆，peek就是最大元素
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.add(new Pair(0, 0, matrix[0][0]));

        // 向heap总添加k个元素
        for(int i = 0; i < k - 1; i ++){
            // 删除最小元素
            Pair cur = minHeap.poll();
            for(int j = 0; j < 2; j ++){
                // 添加右边
                // 添加下边
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                Pair next_Pair = new Pair(next_x, next_y, 0);
                if(next_x < n && next_y < m && !hash[next_x][next_y]){
                    hash[next_x][next_y] = true;
                    next_Pair.val = matrix[next_x][next_y];
                    minHeap.add(next_Pair);
                }
            }
        }

        // 取出最上面元素
        return minHeap.peek().val;
    }

    // solution 2 : binary search
    class ResultType {
        public int num;
        public boolean exists;
        public ResultType(boolean e, int n) {
            exists = e;
            num = n;
        }
    }
    public ResultType check(int value, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean exists = false;
        int num = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (matrix[i][j] == value)
                exists = true;

            if (matrix[i][j] <= value) {
                num += i + 1;
                j += 1;
            } else {
                i -= 1;
            }
        }

        return new ResultType(exists, num);
    }

    public int kthSmallest2(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[n - 1][m - 1];

        // left + 1 < right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ResultType type = check(mid, matrix);
            if (type.exists && type.num == k) {
                return mid;
            } else if (type.num < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {{1,5,7},{3,7,8},{4,8,9}};
        String str1 = "";

        KthSmallestNumberInSortedMatrix xx = new KthSmallestNumberInSortedMatrix();
        xx.kthSmallest(AA, 5);

    }

}
