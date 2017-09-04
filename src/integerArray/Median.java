package integerArray;

/**
 * Created by Lenovo on 2017/4/12.
 * Hard
 * http://www.jiuzhang.com/solutions/median/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72962
 */
public class Median {

    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     *
     * QuickSort的变种
     * 九章的答案太难懂了
     */
    public static int median(int[] nums) {

        return sub(nums, 0, nums.length - 1, (nums.length + 1)/2);
    }
    private static int sub(int[] nums, int start, int end, int size) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        // i左指针  j右指针   k当前指针
        int i = start - 1, j = end + 1;
        for (int k = start; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            } else if (nums[k] > pivot) {
                j--;
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                k--;
            }
        }
        if (i - start + 1 >= size) {
            return sub(nums, start, i, size);
        } else if (j - start >= size) {
            return nums[j-1]; //
        } else {
            return sub(nums, j, end, size - (j - start));
        }
    }

    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     * Version2 : 这个好懂很多
     */
    public static int median2(int[] nums) {
        // write your code here
        int len  = nums.length;
        if (len%2 == 0) return search(nums, len/2, 0, len-1);
        else return search(nums, len/2+1, 0, len-1);
    }

    /**
     *
     * @param nums
     * @param k ： 返回第k大的数字
     * @param start
     * @param end
     * @return
     *
     * QuickSort的变形，QuickSelect
     * 每次选一个pivot放到正确的位置，前面的都比pivot小后面的大于等于pivot
     * 知道pivot正好放入k要求的位置
     */
    public static int search(int[] nums, int k, int start, int end) {
        int l=start, r=end;
        int pivot = r; //选最后一位
        while (l<r) {
            // 左右扫描，注意需要加条件  l < r
            while (nums[l] < nums[pivot] && l<r) {
                l++;
            }
            while (nums[r] >= nums[pivot] && l<r) {
                r--;
            }
            swap(nums, l, r);
        }
        swap(nums, l, end); // 把pivot值放到正确的位置
        if (k-1 == l) return nums[l];
        else if (k-1 > l) return search(nums, k, l+1, end);
        else return search(nums, k, start, l-1);
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args){
        int[] nums = {4,5,3,2,1};
        int result = median2(nums);
        System.out.println(result);
    }
}
