package com.scv;

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




}




//Definition of TreeNode:
class TreeNode {
  public int val;
  public TreeNode left, right;
  public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
  }
}
