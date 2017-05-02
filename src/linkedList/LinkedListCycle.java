package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/5/2.
 * http://www.lintcode.com/en/problem/linked-list-cycle/
 */
public class LinkedListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
