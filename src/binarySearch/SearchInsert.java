package binarySearch;

/**
 * Created by Lenovo on 2017/9/1.
 * http://www.jiuzhang.com/solution/search-insert-position
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72967
 * http://www.lintcode.com/en/problem/search-insert-position/
 */
public class SearchInsert {

    /*
 * @param A: an integer sorted array
 * @param target: an integer to be inserted
 * @return: An integer
 */
    public int searchInsert(int[] A, int target) {
        // write your code here

        if(A == null || A.length == 0){
            return -1;
        }
        // 这里比较难以理解,相当于加了个负无穷和正无穷
        int start = -1, end = A.length;

        // find the last number less than target --》 A[start]
        while(start + 1 < end){
            int mid = start + (end- start)/2;
            if(A[mid] == target){
                return mid;
            }
            else if(A[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return start + 1;
    }

    public int searchInsert2(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;  // 不好理解
        }
    }
}
