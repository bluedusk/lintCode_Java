package com.scv;

/**
 * Created by openworld on 15/9/29.
 * http://www.lintcode.com/zh-cn/problem/segmemt-tree-build-ii/
 */


/**
 * Definition of SegmentTreeNode:
 **/
class SegmentTreeNode {
  public int start, end, max;
  public SegmentTreeNode left, right;
  public SegmentTreeNode(int start, int end, int max) {
      this.start = start;
      this.end = end;
      this.max = max;
      this.left = this.right = null;
  }
}

public class segmemt_tree_build_ii {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return build(0,A.length-1, A);
    }

    public SegmentTreeNode build(int start, int end, int[]array) {
        // write your code here
        if(start > end) {  // check core case
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end,0);

        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, array);
            root.right = build(mid+1, end, array);

            root.max = Math.max(root.left.max, root.right.max);
        } else {
            root.max = array[start];
        }
        return root;
    }
}
