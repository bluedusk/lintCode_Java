package tree;

import common.Interval;

import java.util.ArrayList;

/**
 * Created by openworld on 2017/9/24.
 */
public class IntervalMinimumNumber {

        public SegmentTreeNode build(int start, int end, int[] A) {
            // write your code here
            if (start > end) {  // check core case
                return null;
            }

            SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);

            if (start != end) {
                int mid = (start + end) / 2;
                root.left = build(start, mid, A);
                root.right = build(mid + 1, end, A);

                root.min = Math.min(root.left.min, root.right.min);
            } else {
                root.min = A[start];
            }
            return root;
        }

        public int query(SegmentTreeNode root, int start, int end) {
            // write your code here
            if (start == root.start && root.end == end) { // 相等
                return root.min;
            }


            int mid = (root.start + root.end) / 2;
            int leftmin = Integer.MAX_VALUE, rightmin = Integer.MAX_VALUE;
            // 左子区
            if (start <= mid) {
                if (mid < end) { // 分裂
                    leftmin = query(root.left, start, mid);
                } else { // 包含
                    leftmin = query(root.left, start, end);
                }
            }
            // 右子区
            if (mid < end) { // 分裂 3
                if (start <= mid) {
                    rightmin = query(root.right, mid + 1, end);
                } else { //  包含
                    rightmin = query(root.right, start, end);
                }
            }
            // else 就是不相交
            return Math.min(leftmin, rightmin);
        }

        public ArrayList<Integer> intervalMinNumber(int[] A,
                                                    ArrayList<Interval> queries) {
            // write your code here
            SegmentTreeNode root = build(0, A.length - 1, A);
            ArrayList ans = new ArrayList<Integer>();
            for (Interval in : queries) {
                ans.add(query(root, in.start, in.end));
            }
            return ans;
        }



    class SegmentTreeNode {
        public int start, end, min;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }


    }
