package tree;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openworld on 2017/9/24.
 */
public class IntervalSum {
    class SegmentTreeNode {
        public int start, end;
        public long sum;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end, int[] A) {
        // write your code here
        if (start > end) {  // check core case
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);

        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);

            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum = A[start];
        }
        return root;
    }

    public long query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start == root.start && root.end == end) { // 相等
            return root.sum;
        }


        int mid = (root.start + root.end) / 2;
        long leftSum = 0, rightSum = 0;
        // 左子区
        if (start <= mid) {
            if (mid < end) { // 分裂
                leftSum = query(root.left, start, mid);
            } else { // 包含
                leftSum = query(root.left, start, end);
            }
        }
        // 右子区
        if (mid < end) { // 分裂 3
            if (start <= mid) {
                rightSum = query(root.right, mid + 1, end);
            } else { //  包含
                rightSum = query(root.right, start, end);
            }
        }
        // else 就是不相交
        return leftSum + rightSum;
    }

    public List<Long> intervalSum(int[] A, List<Interval> queries) {

        // write your code here
        SegmentTreeNode root = build(0, A.length - 1, A);
        ArrayList ans = new ArrayList<Long>();
        for (Interval in : queries) {
            ans.add(query(root, in.start, in.end));
        }
        return ans;
    }


}
