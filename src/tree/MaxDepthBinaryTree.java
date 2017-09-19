package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lenovo on 2017/9/19.
 */
public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        // write your code here
        return helper(0,root);
    }

    int helper(int depth, TreeNode node){
        if (node == null){
            return depth;
        }
        return Math.max(helper(depth + 1,node.right),helper(depth + 1,node.left));
    }


    // 九章
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            depth++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return depth;
    }
}
