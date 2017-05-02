package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/5/2.
 * http://www.lintcode.com/en/problem/linked-list-cycle-ii/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73010
 *
 * Hard
 */
public class LinkedListCycle2 {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
