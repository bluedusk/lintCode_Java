package linkedList;

import common.RandomListNode;

import java.util.HashMap;

/**
 * Created by Lenovo on 2017/5/15.
 * http://www.lintcode.com/en/problem/copy-list-with-random-pointer/#
 */
public class CopyRandomList {
    // solution 1
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curNode = dummy;
        HashMap<RandomListNode, RandomListNode> randomMap = new HashMap<RandomListNode, RandomListNode>();
        while (head != null) {
            // link newNode to new List
            RandomListNode newNode = new RandomListNode(head.label);
            curNode.next = newNode;
            // map old node head to newNode
            randomMap.put(head, newNode);
            // copy old node random pointer
            newNode.random = head.random;
            //
            head = head.next;
            curNode = curNode.next;
        }

        // re-mapping old random node to new node
        curNode = dummy.next;
        while(curNode != null) {
            if (curNode.random != null) {
                curNode.random = randomMap.get(curNode.random);
            }
            curNode = curNode.next;
        }

        return dummy.next;
    }


    // solution 2
    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curNode = dummy;
        HashMap<RandomListNode, RandomListNode> hash_map = new HashMap<RandomListNode, RandomListNode>();
        while (head != null) {
            // link newNode to new List
            RandomListNode newNode = null;
            if (hash_map.containsKey(head)) {
                newNode = hash_map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                hash_map.put(head, newNode);
            }
            curNode.next = newNode;
            // re-mapping old random node to new node
            if (head.random != null) {
                if (hash_map.containsKey(head.random)) {
                    newNode.random = hash_map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    hash_map.put(head.random, newNode.random);
                }
            }
            //
            head = head.next;
            curNode = curNode.next;
        }

        return dummy.next;
    }


}
