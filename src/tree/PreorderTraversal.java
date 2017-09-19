package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lenovo on 2017/9/18.
 * Recursive
 * Non-Recursive
 */
public class PreorderTraversal {

    // Recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        helper(result,root);
        return result;

    }

    void helper(List<Integer> result, TreeNode node){

        if(node == null){
            return;
        }
        result.add(node.val);
        helper(result,node.left);
        helper(result,node.right);
    }

    // non-recursive

    /**
     *
     * @param root
     * @return
     * 对root进行异常处理
        将root压入栈
        循环终止条件为栈s为空，所有元素均已处理完
        访问当前栈顶元素(首先取出栈顶元素，随后pop掉栈顶元素)并存入最终结果
        将右、左节点分别压入栈内，以便取元素时为先左后右。
        返回最终结果
        其中步骤4,5,6为迭代的核心，对应前序遍历「根左右」。
        所以说到底，**使用迭代，只不过是另外一种形式的递归。**使用递归的思想去理解遍历问题会容易理解许多。
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }

        return result;

    }
}
