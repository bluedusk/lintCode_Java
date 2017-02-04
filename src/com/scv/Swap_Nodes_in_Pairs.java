package com.scv;

/**
 * Created by openworld on 15/10/27.
 *
 * http://www.lintcode.com/en/problem/swap-nodes-in-pairs/
 *
 */

// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class Swap_Nodes_in_Pairs {

    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here

        ListNode tmp,result;
        if (head == null || head.next == null){
            return head;
        }
        else{
            tmp = head.next.next;
            result = head.next;
            head.next.next = head;
            head.next = swapPairs(tmp);
        }


        return result;
    }


}
