package binarySearch;

/**
 * Created by openworld on 2017/9/2.
 */
public class FindPeak {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     *
     * LintCode和LeeCode不一样。
     */
    public static int findPeak(int[] A) {
        // write your code here

        if (A == null || A.length == 0) return -1;

        int lb = 0, ub = A.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (A[mid] < A[mid + 1]) {
                lb = mid;
            } else if (A[mid] < A[mid - 1]){
                ub = mid;
            } else {
                // find a peak
                return mid;
            }
        }
        return -1;
        // 因为题中给出的假设条件和解析不一样，可以确定有峰值存在；
        // return a larger number
        //return A[lb] > A[ub] ? lb : ub;
    }

    public static void main(String[] args){
        int[] A = {1,2,1,3,4,5,7,6,5};

        int x = findPeak(A);
    }
}
