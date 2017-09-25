package tree;

import common.TreeNode;

/**
 * Created by Lenovo on 2017/9/21.
 */
public class ConvertArrayToBST {

    /**
        本题考查二分查找法
     */
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return buildTree(num, 0, num.length - 1);
    }

    // 如果随便构造一个
    public TreeNode sortedArrayToBST1(int[] num) {
        if (num == null) {
            return null;
        }
        TreeNode root = new TreeNode(num[0]);

        for (int i = 1; i < num.length - 1; i++) {
            TreeNode node = new TreeNode(num[i]);
            node.left = root;
            root = node;
        }
        return root;
    }

    private TreeNode buildTree1(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }
}
