package linkedList;

import common.ListNode;
import common.Util;

/**
 * Created by Lenovo on 2017/5/18.
 * http://www.lintcode.com/en/problem/remove-linked-list-elements/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73023
 */
public class RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null){
            if (head.next.val == val){
               head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = Util.ArrayToList(new int[]{3,1,3,2,0,3});

        ListNode x = removeElements(l1,3);

        Util.printList(x);
    }
}
