package tree;

import common.TreeNode;

/**
 * Created by Lenovo on 2017/9/20.
 * http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 二叉树的重建，典型题。核心有两点：

     1. preorder 先序遍历的第一个节点即为根节点。
     2. 确定 inorder 数组中的根节点后其左子树和右子树也是 preorder 的左子树和右子树。
     其中第二点是隐含条件，数组中没有重复元素，故可以根据先序遍历中第一个元素（根节点）得到根节点的值，
     然后在 inorder 中序遍历的数组中搜索得到根节点的索引值，即为左子树，右边为右子树。
     根据中序遍历中左子树的索引确定先序遍历数组中左子树的起止索引。递归直至处理完所有数组元素。
 */

public class ConstructBinaryTree {

    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);
        root.right = myBuildTree(inorder, position + 1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
}
