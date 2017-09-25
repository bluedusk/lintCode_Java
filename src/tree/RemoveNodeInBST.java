package tree;

/**
 * Created by openworld on 2017/9/23.
 */
public class RemoveNodeInBST {

    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;

        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            // 要删除的是左节点
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            // 要删除的是右节点
            node = parent.right;
        } else {
            // 删除的是叶子节点
            return dummy.left;
        }

        deleteNode(parent, node);

        return dummy.left;
    }

    // 找到要删除节点的父节点
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }

        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }

    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;

            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }

            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }

            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }

            temp.left = node.left;
            temp.right = node.right;
        }
    }
}
