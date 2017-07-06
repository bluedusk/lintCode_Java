package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/7/6.
 * http://www.lintcode.com/en/problem/3sum-closest/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72957
 *
 *
 * 题解1 - 排序 + 2 Sum + 两根指针 + 优化过滤
 和 3 Sum 的思路接近，首先对原数组排序，随后将3 Sum 的题拆解为『1 Sum + 2 Sum』的题，
 对于 Closest 的题使用两根指针而不是哈希表的方法较为方便。
 对于有序数组来说，在查找 Cloest 的值时其实是有较大的优化空间的。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return -1;
        }

        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            // 双指针扫描，注意是扫描不是遍历
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return bestSum;
    }
}
