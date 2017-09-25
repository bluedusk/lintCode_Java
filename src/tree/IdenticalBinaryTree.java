package tree;

import common.TreeNode;

/**
 * Created by Lenovo on 2017/9/22.
 */
public class IdenticalBinaryTree {

    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if(a == null && b != null){
            return false;
        }
        if(a != null && b == null){
            return false;
        }
        if(a == null && b == null){
            return true;
        }
        if(a.val != b.val){
            return false;
        }
        return isIdentical(a.left, b.left) && isIdentical(a.right,b.right);

    }
    // 九章更简洁
    public boolean isIdentical1(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null)
            return true;
        if (a != null && b != null) {
            return a.val == b.val && isIdentical(a.left, b.left)
                    && isIdentical(a.right, b.right);
        }
        return false;
    }
}
