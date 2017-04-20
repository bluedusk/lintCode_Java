package exhaustiveSearch;

/**
 * Created by Lenovo on 2017/4/18.
 * http://www.lintcode.com/zh-cn/problem/next-permutation/
 *https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73053
 *
 * 字典序算法
 * 找下一个升序排列，C++ STL 源码剖析一书中有提及，Permutations 一小节中也有详细介绍，下面简要介绍一下字典序算法：

 从后往前寻找索引满足 a[k] < a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
 从后往前遍历，找到第一个比a[k]大的数a[l], 即a[k] < a[l].
 交换a[k]与a[l].
 反转k + 1 ~ n之间的元素。
 由于这道题中规定对于[4,3,2,1], 输出为[1,2,3,4], 故在第一步稍加处理即可。

 */
public class NextPermutation {

    public int[] nextPermutation(int[] num) {
        if (num == null) {
            return null;
        }

        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {
            if (num[i + 1] > num[i]) {
                int j;
                for (j = len - 1; j > i - 1; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }

                swap(num, i, j);
                reverse(num, i + 1, len-1);
                return num;
            }
        }

        // 如果已经是最大数如4321的结果是1234
        // 这时候也需要reverse
        reverse(num, 0, len-1);
        return num;
    }

    void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i ++, j --) {
            swap(num, i, j);
        }
    }
}
