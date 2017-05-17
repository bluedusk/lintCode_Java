package linkedList;


import common.ListNode;

/**
 * Created by openworld on 17/4/8.
 * http://www.lintcode.com/en/problem/reverse-linked-list/
 * https://www.jiuzhang.com/solutions/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    // recursive
    public ListNode reverse1(ListNode head) {
        // case1: empty list
        if (head == null) return head;
        // case2: only one element list
        if (head.next == null) return head;
        // case3: reverse from the rest after head
        ListNode newHead = reverse(head.next);
        // reverse between head and head->next
        head.next.next = head;
        // unlink list from the rest
        head.next = null;

        return newHead;
    }
}
