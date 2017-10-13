package common;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/10/10.
 */
public class UndirectedGraphNode {
     public int label;
     public ArrayList<UndirectedGraphNode> neighbors;
     public UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<UndirectedGraphNode>();
     }
}
