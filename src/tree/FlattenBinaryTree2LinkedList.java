package tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by Lenovo on 2017/9/22.
 * http://www.cnblogs.com/grandyang/p/4293853.html
 */
public class FlattenBinaryTree2LinkedList {

    // solution 1.0 : recursive
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    // solution1.1 - recursive 2
    public void flatten3(TreeNode root){
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        // 断开right
        TreeNode tmp = root.right;
        // left 接到 right
        root.right = root.left;
        // left = null
        root.left = null;
        // 前进到最后
        while (root.right != null) {
            root = root.right;
        }
        // 将断开的right接回来
        root.right = tmp;
    }

    // solution 2 : divide & conquer
    public void flatten1(TreeNode root) {
        helper(root);
    }

    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLast != null) {
            return rightLast;
        }

        if (leftLast != null) {
            return leftLast;
        }

        return root;
    }

    // solution 3 : non-recursive
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            // connect
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }

}
