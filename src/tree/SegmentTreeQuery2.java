package tree;

import common.SegmentTreeNode;

/**
 * Created by Lenovo on 2017/9/21.
 */
public class SegmentTreeQuery2 {

    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start > end || root==null)
            return 0;
        if(start <= root.start && root.end <= end) { // start~end包含root.left~root.right的区间，则返回root全部count
            return root.count;
        }

        int mid = (root.start + root.end)/2;
        int leftCount = 0, rightCount = 0;

        if(start <= mid){
            if(end < mid){
                leftCount = query(root.left, start,end);
            }else{
                leftCount = query(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightCount = query(root.right, mid+1, end);
            } else { //  包含
                rightCount = query(root.right, start, end);
            }
        }
        // else 就是不相交

        return leftCount + rightCount;
    }
}
