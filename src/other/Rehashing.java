package other;

import common.ListNode;

/**
 * Created by openworld on 2017/9/16.
 */
public class Rehashing {

    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int newCapacity = 2*hashTable.length;
        ListNode[] result = new ListNode[newCapacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode dummy = new ListNode(0);
            dummy.next = hashTable[i];

            while (dummy.next!=null){
                ListNode node = dummy.next;
                int index = (node.val % newCapacity + newCapacity) % newCapacity;;
                if(result[index] != null){
                    ListNode x = result[index];
                    while(x.next != null){
                        x = x.next;
                    }
                    x.next = new ListNode(node.val);
                }
                else{
                    result[index] = new ListNode(node.val);
                }
                dummy = node;
            }
        }
        return result;

    }
}
