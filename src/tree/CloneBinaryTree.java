package tree;

import common.TreeNode;

/**
 * Created by Lenovo on 2017/9/20.
 */
public class CloneBinaryTree {

    /*
 * @param root: The root of binary tree
 * @return: root of new tree
 */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);

        return node;

    }

}
