package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lenovo on 2017/9/18.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73027
 *
 */
public class PostorderTravelsal {

    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        helper(result,root);
        return result;
    }
    void helper(List<Integer> result, TreeNode node){

        if(node == null){
            return;
        }
        helper(result,node.left);
        helper(result,node.right);
        result.add(node.val);

    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode prev = null;
        while (!s.empty()) {
            TreeNode curr = s.peek();
            boolean noChild = false;
            if (curr.left == null && curr.right == null) {
                noChild = true;
            }
            boolean childVisited = false;
            // 判断条件
            if (prev != null && (curr.left == prev || curr.right == prev)) {
                childVisited = true;
            }

            // traverse
            if (noChild || childVisited) {
                result.add(curr.val);
                s.pop();
                prev = curr;
            } else {
                if (curr.right != null) s.push(curr.right);
                if (curr.left != null) s.push(curr.left);
            }

        }

        return result;

    }
}
