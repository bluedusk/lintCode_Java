package graph;

import java.util.*;

/**
 * Created by Lenovo on 2017/10/10.
 */
public class GraphValidTree {

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {{0,1},{1,2},{2,0}};
        String str1 = "";

        GraphValidTree x = new GraphValidTree();
        x.validTree(3,AA);

    }

    // version 1 : BFS

    /**
     *
     * @param n
     * @param edges
     * @return
     *
     * 树满足两个条件：
     * 1. 图是连通图
     * 2. 图没有环
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        // 连通图
        if (edges.length != n - 1) {
            return false;
        }

        // 初始化图数据结构，nodes + edges
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        // start from 0
        queue.offer(0);
        hash.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (hash.contains(neighbor)) {
                    continue;
                }
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }

        return (hash.size() == n);
    }

    // 初始化图数据结构
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // all nodes
        for (int i = 0; i < n; i++) {
            // set 去重
            graph.put(i, new HashSet<Integer>());
        }
        // all edges
        for (int i = 0; i < edges.length; i++) {
            // [1,2] or [2,1]
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }


    // version2 : Union Find
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n){
            for(int i = 0 ; i < n; i++) {
                father.put(i, i);
            }
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = father.get(x);
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;

        }

        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree1(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        if (n - 1 != edges.length) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.length; i++) {
            if (uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
