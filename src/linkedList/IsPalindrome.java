package linkedList;

import common.ListNode;
import common.Util;

import java.util.Stack;

/**
 * Created by Lenovo on 2017/5/18.
 * http://www.lintcode.com/en/problem/palindrome-linked-list/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73019
 */
public class IsPalindrome {

    // solution 1
    // 使用栈，只需要前一半和后一半比较；
    public static boolean isPalindrome(ListNode head) {
        // Write your code here
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();

        // push node before mid
        // find middle: fast = null 是偶数，fast !=null是奇数；
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip mid node for odd size
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();
            // compare top with slow.val
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }




    public static void main(String[] args){
        ListNode l1 = Util.ArrayToList(new int[]{1,2,3,2,1});

        boolean x = isPalindrome(l1);


    }
}
