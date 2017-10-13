package other;

import java.util.HashMap;

/**
 * Created by Lenovo on 2017/10/13.
 */
public class FindTheMissingNumII {

    public boolean flag = false;
    public int ans = 0;
    public int findMissing2(int n, String str) {
        //  a number from 1 to n is found or not
        boolean[] happen = new boolean[n + 1];
        dfs(0, n, str, happen);
        return ans;
    }

    /**
     *
     * @param i
     * @param n
     * @param s
     * @param happen
     */
    public void dfs(int i, int n, String s, boolean[] happen) {
        if (i >= s.length() || flag) {
            if (!flag)
                for (int k = 1; k <= n; k++) {
                    if (!happen[k]) {
                        ans = k;
                    }
                }
            flag = true;
            return;
        }
        int sum = s.charAt(i) - '0';
        int j = i;
        if (sum == 0) {
            return;
        }

        while (sum <= n) {
            // 取一位数
            if (!happen[sum]) {
                happen[sum] = true;
                dfs(j+1, n, s, happen);
                happen[sum] = false;
            }
            // 如果是最后一位了
            j++;
            if (j >= s.length()) {
                break;
            }
            // 取两位数
            sum = sum * 10 + (s.charAt(j) - '0');
        }
    }
}
