package MathBit;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2017/9/8.
 */
public class DicesSum {

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair.
        List<Map.Entry<Integer, Double>> results =
                new ArrayList<Map.Entry<Integer, Double>>();
        // double[x][y] 表示x个骰子和==y的几率
        double[][] f = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; ++i)
            f[1][i] = 1.0 / 6;

        for (int i = 2; i <= n; ++i) // 2-n 个骰子的情况
            for (int j = i; j <= 6 * n; ++j) { // 代表可能的和
                for (int k = 1; k <= 6; ++k) // 每个骰子有6面， 计算1-6每种可能
                    if (j > k)
                        f[i][j] += f[i - 1][j - k]; // 2个骰子和等于4的几率，等于1个筛子等于123的加和； f[2][4] = f[2][4] + f[2][4] + f[2][4]

                f[i][j] /= 6.0; // 多一个骰子计算结果除以6
            }

        // n个骰子最小和 = n, 最大和6* n; 中间连续；
        for (int i = n; i <= 6 * n; ++i)
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, f[n][i]));

        return results;
    }
}
