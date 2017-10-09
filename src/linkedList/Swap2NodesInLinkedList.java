package linkedList;

import common.ListNode;

/**
 * Created by Lenovo on 2017/9/26.
 */
public class Swap2NodesInLinkedList {

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || head.next == null || v1 == v2)
        {
            return head;
        }

        ListNode newHead  = new ListNode(1);
        newHead.next = head;
        ListNode result = newHead;
        ListNode v1Pre = null;
        ListNode v2Pre = null;
        while (newHead.next != null)
        {
            if (newHead.next.val == v1 || newHead.next.val == v2)
            {
                if (v1Pre == null)
                {
                    v1Pre = newHead;
                }
                else
                {
                    v2Pre = newHead;
                    ListNode v1Node = v1Pre.next;
                    ListNode v2Node = v2Pre.next;
                    ListNode temp = v2Pre.next.next;
                    //v1,v2是否相邻
                    boolean b = (v1Node.next == v2Node);
                    v1Pre.next = v2Pre.next;
                    if (b)
                    {
                        v2Node.next = v1Node;
                    }
                    else
                    {
                        v1Pre.next.next = v1Node.next;
                        v2Pre.next = v1Node;
                    }
                    v1Node.next = temp;
                    break;
                }
            }
            newHead = newHead.next;
        }

        return result.next;
    }
}
