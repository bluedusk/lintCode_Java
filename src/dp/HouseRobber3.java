package dp;

import common.TreeNode;

/**
 * Created by Lenovo on 2017/10/12.
 */
public class HouseRobber3 {

    // version 1:
    //dp[i][0]表示以i为根的子树不偷根节点能获得的最高价值，dp[i][1]表示以i为根的子树偷根节点能获得的最高价值
    public int houseRobber3(TreeNode root) {
        int[] ans = dp(root);
        return Math.max(ans[0], ans[1]);
    }
    public int[] dp(TreeNode root) {
        if (root == null) {
            int[] now = new int[]{0, 0};
            return now;
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int[] now = new int[2];
        // 不偷 root
        now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷 root
        now[1] = left[0] + right[0] + root.val;
        return now;
    }

    // version 2:
    class ResultType {
        public int rob, not_rob;
        public ResultType() { rob = not_rob = 0; }
    }

    public int houseRobber31(TreeNode root) {
        // write your code here
        ResultType result = visit(root);
        return Math.max(result.rob, result.not_rob);
    }

    public ResultType visit(TreeNode root) {
        ResultType result = new ResultType();
        if (root == null)
            return result;

        ResultType left_result = visit(root.left);
        ResultType right_result = visit(root.right);

        result.rob = root.val + left_result.not_rob + right_result.not_rob;
        result.not_rob = Math.max(left_result.rob, left_result.not_rob) +
                Math.max(right_result.rob, right_result.not_rob);
        return result;
    }


}
