package tree;

import common.TreeNode;

import java.util.*;

/**
 * Created by Lenovo on 2017/9/19.
 */
public class ZigzagLevelOrderTraversal {

    // solution 1 : update from level order
    // 只需要在level order基础上处理逆序的level
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root); // 加入根节点
        int level = 0;
        while (!q.isEmpty()) {
            int qLen = q.size();
            ArrayList<Integer> aList = new ArrayList<Integer>();
            Stack<Integer> s = new Stack<>();

            // 一个循环处理一个level
            for (int i = 0; i < qLen; i++) {
                // 取出并删除一个元素
                TreeNode node = q.poll();
                // left to right 正常加入和正序遍历一样
                if(level%2 == 0){
                    aList.add(node.val);
                }
                // right to left 先不加入list, 而是压入stack
                else{
                     s.add(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

            }

            level ++;
            // 如果是 right to left
            while(!s.isEmpty()){
                aList.add(s.pop());
            }

            result.add(aList);
        }
        return result;
    }
    // solution 2 : jiuzhagn
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;

        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;

    }
}
