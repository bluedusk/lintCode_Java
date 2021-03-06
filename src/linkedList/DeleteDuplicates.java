package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/4/25.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73002
 */
public class DeleteDuplicates {

    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) return null;

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
