package linkedList;

import common.ListNode;

import java.util.Stack;

/**
 * Created by Lenovo on 2017/9/25.
 * 一个简单的方法是两个list分别转换为数字然后相加，再把结果转换为list, 但是应该不是考察点；
 *
 */
public class AddTwoNumbers2 {

    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        ListNode result = new ListNode(0);

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if (!s1.empty()) {sum += s1.pop(); }
            if (!s2.empty()) {sum += s2.pop(); }
            result.val = sum % 10;
            ListNode head = new ListNode( sum / 10);
            head.next = result;
            result = head;
            sum /= 10;
        }
        return result.val == 0 ? result.next : result;
    }


}
