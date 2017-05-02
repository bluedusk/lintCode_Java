package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/4/25.
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73003
 */
public class DeleteDuplicates2 {

    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) return null;

        // 当前节点可能被删除，设置dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        // 注意判断条件
        while(node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int val_prev = node.next.val;
                // 处理所有的重复节点;
                while (node.next != null && node.next.val == val_prev) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return dummy.next;
    }
}
