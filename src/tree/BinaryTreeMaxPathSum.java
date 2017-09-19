package tree;

import common.TreeNode;
import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2017/9/19.
 */
public class BinaryTreeMaxPathSum {

    public int maxPathSum(TreeNode root) {
        int res = root.val;
        // 因为需要传引用值到递归方法，因此用map对象保存；
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("max",res);
        maxPathSumDFS(root,  map);
        return map.get("max");
    }

    // 从node到所有叶子节点中，和最大的一条
    int maxPathSumDFS(TreeNode node,Map<String, Integer> map) {
        if (node == null) return 0;
        int left = maxPathSumDFS(node.left, map);
        int right = maxPathSumDFS(node .right, map);
        // 以node为根节点的 sum path;
        int top = node.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        map.put("max",Math.max(map.get("max"), top));
        // 因为取最大的一条，因此取左边或者右边
        return Math.max(left, right) > 0 ? Math.max(left, right) + node .val : node .val;
    }
}
