package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lenovo on 2017/9/18.
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
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
        result.add(node.val);
        helper(result,node.right);
    }

    /**
     *
     * @param root
     * @return
     *
     * 使用辅助栈改写递归程序，中序遍历没有前序遍历好写，其中之一就在于入栈出栈的顺序和限制规则。我们采用「左根右」的访问顺序可知主要由如下四步构成。

        1. 首先需要一直对左子树迭代并将非空节点入栈
        2. 节点指针为空后不再入栈
        3.  当前节点为空时进行出栈操作，并访问栈顶节点
        4. 将当前指针p用其右子节点替代
        步骤2,3,4对应「左根右」的遍历结构，只是此时的步骤2取的左值为空。
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.empty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                result.add(root.val);
                root = root.right;
            }
        }

        return result;

    }
}
