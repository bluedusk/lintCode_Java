package common;

/**
 * Created by Lenovo on 2017/5/4.
 */
public class Util {

    public static ListNode ArrayToList(int[] array){

        ListNode head = new ListNode(0);
        ListNode cur = head;

        for (int i: array) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }

        return head.next;
    }
    public static void printList(ListNode l){
        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
    public static void main(String[] args){

        int[] x = {1,3,8,11,15};

        ListNode l = ArrayToList(x);

        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }


    }
}
