package linkedList;

import common.ListNode;

/**
 * Created by openworld on 15/10/27.
 *
 * http://www.lintcode.com/en/problem/swap-nodes-in-pairs/
 *
 */

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

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode after = head.next;
        head.next = swapPairs(after.next);
        after.next = head;

        return after;
    }


}
