package com.scv;

/**
 * Created by openworld on 17/4/9.
 * http://www.lintcode.com/en/problem/sort-colors-ii/
 * https://www.jiuzhang.com/solutions/sort-colors-ii/
 */
public class SortColors2 {

    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     *
     * 快速排序的思路
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    /**
     * 实际上是快排, 区别是选mid的时候，后面对mid不作处理
     * 而是简单的把小的swap到前面，大的swap到后面；

     * @param colors  排序数组
     * @param left    左指针（用于交换数据）
     * @param right   右指针
     * @param colorFrom   当前递归color的最小值
     * @param colorTo     当前递归color的最大值
     */
    public void rainbowSort(int[] colors,
                            int left,
                            int right,
                            int colorFrom,
                            int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }

        if (left >= right) {
            return;
        }
        // 选取mid值用于划分数组， 这个值可能在数组中并不存在
        // 下面是类似快排的逻辑
        int colorMid = (colorFrom + colorTo) / 2;
        int l = left, r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            }
            while (l <= r && colors[r] > colorMid) {
                r--;
            }
            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;

                l++;
                r--;
            }
        }
        // 对左右部分递归快排
        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }

    /**
     * 非递归版本，这个版本的关键是每次循环处理好当前min和max的值
     * 将min和max放到当前数组的最前和最后，然后在下一个循环处理余下部分
     * 通过这种方法达到收敛效果
     *
     * @param colors
     * @param k
     */
    public void sortColors21(int[] colors, int k) {
        int count = 0;
        int start = 0;
        int end = colors.length - 1;
        while (count < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // 每次循环处理当前的min和max值， 先选出当前的最大和最小color
            for (int i = start; i <= end; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }

            // 用于比较的三个指针
            int left = start;
            int right = end;
            int cur = left;
            while(cur <= right) {
                // 值==min, swap到最前
                if (colors[cur] == min) {
                    swap(left, cur, colors);
                    cur++;
                    left++;
                }
                // 值不等于min或max, 不swap
                else if (colors[cur] > min && colors[cur] < max) {
                    cur++;
                }
                // 值==max, swap到最后
                else {
                    int tmp = colors[cur];
                    swap(cur, right, colors);
                    right--;
                }
            }
            // 当前循环处理完成，min和max已经在最前和最后
            count += 2;
            start = left;
            end = right;
        }
    }

    void swap(int left, int right, int[] colors) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
}
