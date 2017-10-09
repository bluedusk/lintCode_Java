package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/9/25.
 */
public class Nth2LastNodeInList {

    public ListNode nthToLast(ListNode head, int n) {
        // write your code here

        ListNode slow = head;
        ListNode fast = head;

        while(n>0){
            fast = fast.next;
        }
        // 注意这个判断
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
