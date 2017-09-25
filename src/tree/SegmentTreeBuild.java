package tree;

import common.SegmentTreeNode;

/**
 * Created by Lenovo on 2017/9/21.
 */
public class SegmentTreeBuild {


    public SegmentTreeNode build(int start, int end) {
        // write your code here
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        if(start>end){
            return null;
        }
        helper(root);
        return root;

    }
    void helper(SegmentTreeNode A){

        if(A == null || A.start == A.end){
            return;
        }
        if(A.start < (A.start + A.end) / 2){
            A.left = new SegmentTreeNode(A.start,(A.start + A.end) / 2);
        }
        else{
            A.left = null;
        }
        if((A.start + A.end) / 2 + 1 < A.end){
            A.right = new SegmentTreeNode((A.start + A.end) / 2 + 1, A.end);
        }
        else{
            A.right = null;
        }
        helper(A.left);
        helper(A.right);
    }
}
