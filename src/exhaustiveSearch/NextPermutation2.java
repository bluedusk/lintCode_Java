package exhaustiveSearch;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Lenovo on 2017/10/7.
 */
public class NextPermutation2 {

    public static void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

    public static void nextPermutation(int[] num) {
        // find the last increase index
        int index = -1;
        // 找到应该交换的位置 index
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index = i;
                break;
            }
        }
        // 不存在
        if (index == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }

        // find the first bigger one
        // 从后向前找到第一个大于index位置的数字
        int biggerIndex = index + 1;
        for (int i = num.length - 1; i > index; i--) {
            if (num[i] > num[index]) {
                biggerIndex = i;
                break;
            }
        }

        // swap them to make the permutation bigger
        int temp = num[index];
        num[index] = num[biggerIndex];
        num[biggerIndex] = temp;

        // reverse the last part
        // 注意注意这个reverse
        reverse(num, index + 1, num.length - 1);
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {1,2,4,7,6,5,3};
        // 找到 index = 4的位置；
        // 找到 biggerIndex = 5的位置
        // 交换 4 和 5 的位置
        // reverse 交换后5之后的数组
        int[][] AA = {};
        String str1 = "";

        nextPermutation(A);

    }
}
