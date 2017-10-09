package tree;

import common.DoublyListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/25.
 */
public class ConvertBST2DoublyLinkedList {

    // 当前节点
    DoublyListNode lastPointer = null;
    // 头结点
    DoublyListNode dummy = null;

    public void toll(TreeNode n) {
        if (n != null) {
            toll(n.left);
            DoublyListNode node = new DoublyListNode(n.val);
            if (lastPointer == null) {
                lastPointer = node;
                // 头结点
                dummy = node;
            } else {
                lastPointer.next = node;
                node.prev = lastPointer;
                lastPointer = node;
            }
            toll(n.right);
        }
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        toll(root);
        return dummy;

    }

    public List<Integer> inorderTraversal(common.TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    void helper(List<Integer> result, common.TreeNode node) {

        if (node == null) {
            return;
        }
        helper(result, node.left);
        DoublyListNode dNode = new DoublyListNode(node.val);

        result.add(node.val);
        helper(result, node.right);
    }
}
