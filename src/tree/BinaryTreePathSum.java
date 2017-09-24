package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openworld on 2017/9/23.
 */
public class BinaryTreePathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        helper(result,root,path,target,0);
        return result;


    }

    void helper(List<List<Integer>> result, TreeNode node, List<Integer> path, int target, int sum){


        path.add(node.val);
        sum += node.val;


        if(node.left == null && node.right == null && sum == target){
            // 注意一定要new
            result.add(new ArrayList<Integer>(path));
            return;
        }



        if(node.left != null){

            helper(result,node.left,path,target,sum);
            path.remove(path.size() - 1);

        }
        if(node.right != null){

            helper(result,node.right,path,target,sum);
            path.remove(path.size() - 1);

        }
    }


}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
