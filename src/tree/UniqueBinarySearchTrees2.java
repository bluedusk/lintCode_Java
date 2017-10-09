package tree;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/10/7.
 */
public class UniqueBinarySearchTrees2 {

    public static ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private static ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

        if(start > end){
            rst.add(null);
            return rst;
        }

        for(int i=start; i<=end; i++){
            ArrayList<TreeNode> left = generate(start, i-1);
            ArrayList<TreeNode> right = generate(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    // should new a root here because it need to
                    // be different for each tree
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str1 = "";

        generateTrees(3);


    }
}
