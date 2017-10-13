package graph;

import common.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lenovo on 2017/10/10.
 */
public class RouteBetweenTwoNodesInGraph {


    // BFS

    /**
     *
     * @param graph
     * @param s
     * @param t
     * @return
     *
     * 1. queue 实现
     * 2. set 去重
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {

        if (s == t)
            return true;

        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (visited.contains(node.neighbors.get(i))) {
                    continue;
                }
                visited.add(node.neighbors.get(i));
                queue.offer(node.neighbors.get(i));
                if (node.neighbors.get(i) == t) {
                    return true;
                }
            }
        }

        return false;
    }
}
