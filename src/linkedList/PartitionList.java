package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/4/26.
 * http://www.lintcode.com/en/problem/partition-list/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73005
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode leftDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode right = rightDummy;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
            node = node.next;
        }
        // post-processing
        right.next = null;
        left.next = rightDummy.next;

        return leftDummy.next;
    }


}
