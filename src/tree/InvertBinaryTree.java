package tree;

import common.TreeNode;

/**
 * Created by openworld on 15/7/21.
 * Invert Binary Tree
 */
public class InvertBinaryTree {


    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null){
            return;
        }

        if(root.left == null && root.right == null){
            return;
        }

        TreeNode tn = root.left;
        root.left = root.right;
        root.right = tn;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

    }

    ///递归的实现非常简单，那么非递归的如何实现呢？
    // 如果将递归改写成栈的实现，那么简单来讲就需要两个栈了，稍显复杂。
    // 其实仔细观察此题可发现使用 level-order 的遍历次序也可实现。
    // 即从根节点开始入队，交换左右节点，并将非空的左右子节点入队，从队列中取出节点，交换之，直至队列为空。






}
