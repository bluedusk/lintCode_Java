package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/5/18.
 * http://www.lintcode.com/en/problem/rotate-list/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73021
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        // write your code here

        if (head == null) return head;
        ListNode fast = head, slow = head;
        int len = 1;
        for (len = 1; fast.next != null && len <= k; len++) {
            fast = fast.next;
        }
        // k mod len if k > len
        if (len <= k) {
            k = k % len;
            fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
        }
        // forward slow and fast
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // return new head
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }


}
