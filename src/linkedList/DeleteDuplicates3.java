package linkedList;

import common.ListNode;

import java.util.HashMap;

/**
 * Created by Lenovo on 2017/4/25.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73004
 */
public class DeleteDuplicates3 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        hash.put(curr.val, true);
        while (curr.next != null) {
            if (hash.containsKey(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                hash.put(curr.next.val, true);
                curr = curr.next;
            }
        }

        return head;
    }
}
