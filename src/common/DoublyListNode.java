package common;

/**
 * Created by Lenovo on 2017/9/25.
 */
   public class DoublyListNode {
       public int val;
       public DoublyListNode next, prev;
       public DoublyListNode(int val) {
           this.val = val;
           this.next = this.prev = null;
       }
   }