package com.scv;

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
}
