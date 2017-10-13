package graph;

import common.UndirectedGraphNode;
import tree.UniqueBinarySearchTrees;

import java.util.*;

/**
 * Created by Lenovo on 2017/10/10.
 */
public class CloneGraph {

    // fail
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return node;
        }
        // write your code here
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        HashMap<Integer,Boolean> visited = new HashMap<Integer, Boolean>();
        helper(root, node.neighbors,visited);
        return root;
    }

    // deep copy

    /***
     * 将neighbors复制给node
     * @param node
     * @param neighbors
     */
    void helper(UndirectedGraphNode node, ArrayList<UndirectedGraphNode> neighbors, HashMap<Integer,Boolean> visited){

        visited.put(node.label,true);

        ArrayList<UndirectedGraphNode> neighborsCopy = new ArrayList<UndirectedGraphNode>();

        if(neighbors == null || neighbors.isEmpty()){
            node.neighbors = neighborsCopy;
            return;
        }
        for (UndirectedGraphNode item: neighbors) {
            if (visited.getOrDefault(item.label,false)){
                continue;
            }
            UndirectedGraphNode itemCopy = new UndirectedGraphNode(item.label);
            if (!item.neighbors.isEmpty()){
                helper(itemCopy, item.neighbors,visited);
            }else{
                itemCopy.neighbors = item.neighbors;
                return;
            }

            neighborsCopy.add(itemCopy);
        }

        node.neighbors = neighborsCopy;

    }


    // jiuzhang
    // 1. 复制所有节点
    // 2. 复制所有边
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    // bfs 得到所有不重复节点
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        // 去重
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
