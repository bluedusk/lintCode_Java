package linkedList;

import common.ListNode;
import common.Util;

/**
 * Created by Lenovo on 2017/5/17.
 * http://www.lintcode.com/en/problem/insertion-sort-list/
 */
public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        // write your code here

        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把cur开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        ListNode cur = head;
        // 两个列表cur指向未排序list
        // pre指向排序list, 每次都从dummy出发
        while (cur != null) {
            // 每次都从dummy出发
            ListNode pre = dummy;
            // 在已排序列表中，找到一个比未排序大的node, 将剩余列表的cur插入到node前面
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // 找到pre.next是比cur大的node
            // 将cur插入到pre后面
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = Util.ArrayToList(new int[]{1,3,2,0});

        ListNode x = insertionSortList(l1);

        Util.printList(x);
    }
}
