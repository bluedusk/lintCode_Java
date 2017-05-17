package linkedList;

import common.ListNode;
import common.Util;

/**
 * Created by Lenovo on 2017/5/4.
 */
public class MergeTwoLists {

    /**
     * @param  l1 is the head of the linked list
     * @param  l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        // 注意dummy始终指向l1和l2中最小头结点，也就是结果的头结点
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = Util.ArrayToList(new int[]{1,3,8,11,15});
        ListNode l2 = Util.ArrayToList(new int[]{2,5});

        ListNode x = mergeTwoLists(l1,l2);

        Util.printList(x);
    }
}
