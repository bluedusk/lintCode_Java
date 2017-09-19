package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lenovo on 2017/9/19.
 */
public class MinDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(1,root);
    }

    int helper(int depth, TreeNode node){
        // 考虑 {1，#，2,3} 的情况；root.left == null; 此时不能结束，只能放弃这个节点。
        if(node == null){
            return Integer.MAX_VALUE;
        }
        // 到达叶子节点
        if(node.left == null && node.right == null){
            return depth;
        }
        return Math.min(helper(depth+1,node.left),helper(depth+1,node.right));
    }

    // 2. 九章，递归可以不传 depth
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode node){
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }


    // 3. non recursive
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        // level 遍历
        while (!q.isEmpty()) {
            depth++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                // 发现一个叶子节点，结束
                if(node.left == null & node.right == null){
                    return depth;
                }
            }
        }
        return depth;
    }
}
