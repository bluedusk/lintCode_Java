package binarySearch;

/**
 * Created by openworld on 2017/9/3.
 */
public class WoodCut {

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) return 0;

        int lb = 0, ub = Integer.MAX_VALUE;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (C(L, k, mid)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb;
    }

    //定义私有方法C为切分为 x 长度时能否大于等于 k 段。若满足条件则更新lb
    // whether it cut with length x and get more than k pieces
    private boolean C(int[] L, int k, int x) {
        int sum = 0;
        for (int l : L) {
            sum += l / x;
        }
        return sum >= k;
    }
}
