package binarySearch;

/**
 * Created by openworld on 2017/9/2.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72975
 */
public class FindMinRSA {

    public static int findMin(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;

        int lb = 0, ub = num.length - 1;
        // case1: num[0] < num[num.length - 1]
        // if (num[lb] < num[ub]) return num[lb];

        // case2: num[0] > num[num.length - 1] or num[0] < num[num.length - 1]
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (num[mid] < num[ub]) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return Math.min(num[lb], num[ub]);
    }

    public static void main(String[] args){
        int[] A = {6, 7, 1, 2, 3,4,5};
        int[] A1 = {1,2,3,4,5,6,7,8,10,11,0};
        int[] A2 = {1,2,3,4,5,6,7,8,10,11};

        findMin(A1);
    }
}
