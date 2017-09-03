package binarySearch;

/**
 * Created by openworld on 2017/9/2.
 */
public class SearchRotatedSortedArray {

    /*
 * @param A: an integer rotated sorted array
 * @param target: an integer to be searched
 * @return: an integer
 *
 * solution 1:
 * 1. find pivot
 * 2. binary search left half or right half
 */
    public static int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int pivot = findPivot(A);
        if(pivot == 0){ //没有旋转
            return binarySearch(A,target,0,A.length-1);
        }

        if(target == A[pivot]){
            return pivot;
        }
        // 注意这里的比较是和最后一个元素比较！
        else if(target > A[A.length - 1]){
            return binarySearch(A,target,0,pivot-1);
        }
        else{
            return binarySearch(A,target,pivot+1,A.length-1);
        }

    }

    public static int binarySearch(int[] A, int target, int start, int end){

        int lb = start, ub = end;
        int result = -1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if(A[mid] == target){
                result = mid;
                return result;
            }
            else if(A[mid] < target){
                lb = mid;
            }
            else{
                ub = mid;
            }

        }
        if(A[lb] == target){
            result = lb;
        }
        if(A[ub] == target){
            result = ub;
        }
        return result;
    }

    public static int findPivot(int[] A){

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if(A[mid] > A[ub]){
                lb = mid;
            }
            else{
                ub = mid;
            }

        }
        int x = A[lb] > A[ub] ? ub : lb;
        return x;

    }

    // solution2
    public int search2(int[] A, int target) {
        if (A == null || A.length == 0) return -1;

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (A[mid] == target) return mid;

            if (A[mid] > A[lb]) {
                // case1: numbers between lb and mid are sorted
                if (A[lb] <= target && target <= A[mid]) {
                    ub = mid;
                } else {
                    lb = mid;
                }
            } else {
                // case2: numbers between mid and ub are sorted
                if (A[mid] <= target && target <= A[ub]) {
                    lb = mid;
                } else {
                    ub = mid;
                }
            }
        }

        if (A[lb] == target) {
            return lb;
        } else if (A[ub] == target) {
            return ub;
        }
        return -1;
    }


    public static void main(String[] args){
        int[] A = {6, 7, 1, 2, 3,4,5};
        int[] A1 = {1,2,3,4,5,6,7,8,10,11,0};
        int[] A3 = {0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
        //findPivot(A1);
        //binarySearch(A1,9,0,A1.length-1);
        search(A3, -9);
    }
}
