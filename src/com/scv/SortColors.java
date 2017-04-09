package com.scv;

/**
 * Created by openworld on 17/4/9.
 * http://www.lintcode.com/en/problem/sort-colors/
 *
 * 分析：
 * 只有012所以可以遍历出012的数目然后重建array,这样需要循环两次
 */
public class SortColors {

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        // 三个指针； 左指针，右指针，当前值指针（用于和左右比较）
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while (i <= pr) {
            // 所有0, swap到左边, 即使左指针pl位置也是0
            if (a[i] == 0) {
                swap(a, pl, i);
                pl++;
                i++;
            }
            //所有1, 保持当前位置，1永远等待背02swap
            else if(a[i] == 1) {
                i++;
            }
            // 所有2, swap到右边
            else {
                swap(a, pr, i);
                pr--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
