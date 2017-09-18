import java.util.Stack;

/**
 * Created by openworld on 2017/9/10.
 */
public class ValidParentheses {

    public static boolean isValidParentheses(String s) {
        // write your code here
        Stack<Character> stack = new Stack();

        if(s.length()<2){
            return false;
        }
        char[] c = s.toCharArray();
        stack.push('x');
        for (int i = 0; i < c.length; i++) {
            // 注意peek空的stack会报错
            if(stack.peek() == '(' && c[i] == ')'
                    ||stack.peek() == '[' && c[i] == ']'
                    ||stack.peek() == '{' && c[i] == '}'){
                stack.pop();
            }
            else{
                stack.push(c[i]);
            }
        }
        return stack.size() == 1;
    }

    public static  void main(String[] args){
        isValidParentheses("[");
    }
}
