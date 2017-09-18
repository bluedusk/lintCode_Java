package integerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/14.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 3; i++) {

            // fist loop, 取得第一个num1，需要跳过重复
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }

            // 2nd loop, 取得num2
            for (int j = i + 1; j < num.length - 2; j++) {
                // 跳过重复
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;

                int left = j + 1;  // num3
                int right = num.length - 1;  // num4
                // 这里基本上是2sum的解法
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        rst.add(tmp);
                        left++;
                        right--;
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return rst;
    }

}
