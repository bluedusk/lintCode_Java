package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/5/2.
 * http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73008
 *
 * 快慢指针
 */
public class RemoveNthFromEnd {

    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            // n > list.length
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        // when head == null, preDelete is in position of n-1
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
