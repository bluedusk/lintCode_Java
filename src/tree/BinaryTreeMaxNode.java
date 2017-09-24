package tree;

/**
 * Created by openworld on 2017/9/23.
 */
public class BinaryTreeMaxNode {

    TreeNode maxNode = null;

    TreeNode getMaxNode(TreeNode a, TreeNode b){
        return a.val > b.val ? a : b;
    }
    public TreeNode maxNode(TreeNode root) {
        // write your code here

        if(root == null){
            return maxNode;
        }
        maxNode = root;

        TreeNode x = getMaxNode(maxNode(root.left), maxNode(root.right));
        return getMaxNode(root,x);

    }
}
