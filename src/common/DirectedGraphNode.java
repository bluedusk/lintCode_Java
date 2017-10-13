package common;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/10/10.
 */
public class DirectedGraphNode {

        public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<DirectedGraphNode>();
      }
}
