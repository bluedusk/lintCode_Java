package tree;

import common.TreeNode;

import java.util.*;

/**
 * Created by Lenovo on 2017/9/20.
 */
public class LowestCommonAncestor {

    // 注意返回值
    // 分治法
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode A, TreeNode B) {

        // 到达节点，没找到，或找到A或者B
        if ( node == null || node == A || node == B) return node;


        // left : 在左边是否能找到A或者B
        TreeNode left = lowestCommonAncestor(node.left, A, B);
        // right : 在右边是否能找到A或者B
        TreeNode right = lowestCommonAncestor(node.right, A, B);

        // A and B are on both sides
        if ((null != left) && (null != right)) return node;

        // either left or right or NULL
        return (null != left) ? left : right;
    }
}
