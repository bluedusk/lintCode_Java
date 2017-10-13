package graph;

import common.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lenovo on 2017/10/10.
 */
public class TopologicalSorting {


    // BFS
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        // node 入度计数
        // 入度为0的是起点
        // 入度>1的，也就是有多个节点指向，不能添加多次
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();

        // 入度为0的节点，因为拓扑一定存在，所以入度为0的节点只有一个
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                // 加入队列和result
                q.offer(node);
                result.add(node);
            }
        }
        // BFS
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}
