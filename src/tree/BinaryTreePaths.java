package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/22.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here

        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root,result,new StringBuilder());
        return  result;
    }

    void helper(TreeNode node, List<String> result, StringBuilder sb){

        sb.append("->"+node.val);

        if(node.left == null && node.right == null){
            // found one path
            // 去掉root节点前面的 ->
            result.add(sb.toString().substring(2));
        }

        // 注意一定要传入new StringBuilder
        if(node.left != null){
            helper(node.left,result,new StringBuilder(sb.toString()));
        }
        if(node.right != null){
            helper(node.right,result,new StringBuilder(sb.toString()));
        }
    }

    // solution 2
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths1(root.left);
        List<String> rightPaths = binaryTreePaths1(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }

        return paths;
    }
}
