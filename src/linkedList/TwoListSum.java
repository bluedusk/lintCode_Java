package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/4/26.
 * http://www.lintcode.com/en/problem/add-two-numbers/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73006
 *
 * 使用一个新的 List存储结果
 */
public class TwoListSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        // 是否进位
        int carry = 0;

        // l1 & l2 not reach end
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        // l2 reaches end
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        // l1 reached end
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        // 如果最高位进1
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }

}
