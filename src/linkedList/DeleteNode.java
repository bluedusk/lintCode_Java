package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/5/18.
 * http://www.lintcode.com/en/problem/delete-node-in-the-middle-of-singly-linked-list/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73020
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) node = null;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
