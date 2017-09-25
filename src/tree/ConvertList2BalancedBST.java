package tree;

import common.ListNode;
import common.TreeNode;

/**
 * Created by Lenovo on 2017/9/22.
 * http://www.lintcode.com/en/problem/convert-sorted-list-to-balanced-bst/
 *
 * 比快慢指针找中点更巧妙
 */
public class ConvertList2BalancedBST {

    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }

}
