package tree;

/**
 * Created by openworld on 2017/9/23.
 */
public class InsertNodeInBST {

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null){
            root = node;
            return root;
        }
        TreeNode target = helper(root,node);
        if(node.val > target.val){
            target.right = node;
        }
        else{
            target.left = node;
        }
        return root;
    }

    TreeNode helper(TreeNode root, TreeNode node){

        if(node.val > root.val){
            if(root.right == null){
                return root;
            }
            return helper(root.right,node);
        }
        else{
            if(root.left == null){
                return root;
            }
            return helper(root.left,node);
        }
    }

    // solution 2
    public TreeNode insertNode1(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    // solution 3
    public TreeNode insertNode2(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return root;
        }
        TreeNode tmp = root;
        TreeNode last = null;
        // 循环找到最后一个节点
        while (tmp != null) {
            last = tmp;
            if (tmp.val > node.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }
        return root;
    }
}
