package com.scv;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/3/9.
 *http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
 * http://lintcode.com/zh-cn/problem/search-range-in-binary-search-tree/
 * 非递归方式？
 */
public class SearchRangeTree {
    private ArrayList<Integer> results;

    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        results = new ArrayList<Integer>();
        helper(root, k1, k2);
        return results;
    }

    // 递归搜索
    private void helper(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            helper(root.left, k1, k2);
        }
        // 符合条件的值，加入results
        if (root.val >= k1 && root.val <= k2) {
            results.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2);
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
}
