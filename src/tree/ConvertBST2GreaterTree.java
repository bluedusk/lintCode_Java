package tree;

/**
 * Created by openworld on 2017/9/23.
 */
public class ConvertBST2GreaterTree {


    /**
     * @param root the root of binary tree
     * @return the new root
     */
    public int sum = 0;

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            helper(root.right);
        }

        root.val = (sum += root.val);
        if (root.left != null) {
            helper(root.left);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        helper(root);
        return root;
    }


// version: 高频题班
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    int sum1 = 0;

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.right);
        sum1 += cur.val;
        cur.val = sum1;
        dfs(cur.left);
    }

    public TreeNode convertBST1(TreeNode root) {
        // Write your code here
        dfs(root);
        return root;
    }
}