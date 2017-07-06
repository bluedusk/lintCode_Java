package integerArray;

import java.util.ArrayList;

/**
 * Created by openworld on 17/4/9.
 * https://www.jiuzhang.com/solutions/recover-rotated-sorted-array/
 *首先可以想到逐步移位，但是这种方法显然太浪费时间，不可取。下面介绍利器『三步翻转法』，以[4, 5, 1, 2, 3]为例。
 首先找到分割点5和1
 翻转前半部分4, 5为5, 4，后半部分1, 2, 3翻转为3, 2, 1。整个数组目前变为[5, 4, 3, 2, 1]
 最后整体翻转即可得[1, 2, 3, 4, 5]
 由以上3个步骤可知其核心为『翻转』的in-place实现。使用两个指针，一个指头，一个指尾，使用for循环移位交换即可。

 * 注意三次reverse会得到结果；
 * 1. 前半部分
 * 2. 后半部分
 * 3. 全部reverse
 */
public class RecoverRotatedSortedArray {

    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    private static void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // 找到中轴值, index是中轴的前一个元素
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                // 三次reverse
                reverse(nums, 0, index);
                reverse(nums, index + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }

    public static void Main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);

        recoverRotatedSortedArray(nums);
    }
}
