package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openworld on 2017/9/10.
 */
public class GenerateParentheses {

    public static void main(String[] args){
//        foo(0);
        generateParenthesis(3);
    }
    public static void foo(int i){
        if(i==3){
            return;
        }
        foo(i+1);
    }
    // Solution 1
    // recursive
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    // 深度优先搜索
    public static void helper(ArrayList<String> result,
                       String paren, // current paren
                       int left,     // how many left paren we need to add
                       int right) {  // how many right paren we need to add
        System.out.println(paren);
        if (left == 0 && right == 0) {
            result.add(paren);
            System.out.println(paren);
            return;
        }

        if (left > 0) {
            helper(result, paren + "(", left - 1, right);
        }

        if (right > 0 && left < right) { // 注意left<right才会形成括号
            helper(result, paren + ")", left, right - 1);
        }
    }
}
