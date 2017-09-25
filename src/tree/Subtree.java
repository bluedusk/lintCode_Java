package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/20.
 */
public class Subtree {


    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2 == null){
            return true;
        }
        if(T1 == null ){
            return false;
        }
        return isSameTree(T1,T2) ||isSubtree(T1.left, T2) || isSubtree(T1.right, T2);

    }

    boolean isSameTree(TreeNode T1, TreeNode T2){
        if(T1 == null && T2 == null){
            return true;
        }
        if(T1 == null && T2 != null || T1 != null && T2 == null){
            return false;
        }
        if(T1.val != T2.val){
            return false;
        }
        return isSameTree(T1.left,T2.left) && isSameTree(T1.right,T2.right);
    }


}
