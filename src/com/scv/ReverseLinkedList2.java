package com.scv;

/**
 * Created by openworld on 17/4/8.
 * http://www.lintcode.com/en/problem/reverse-linked-list-ii/
 * https://www.jiuzhang.com/solutions/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {

    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code


        // pointer to original head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy; // if starts from 1; we need a 'pre' pointer here

        // move to m
        for (int i = 1; i<m; i++){
            head = head.next;
        }
        //both m and n point at m; n moves forward while m stays
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;

        // reverse m to n
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }

        // deal with prem and postn
        premNode.next = nNode;
        mNode.next = postnNode;

        return dummy.next;
    }

}
