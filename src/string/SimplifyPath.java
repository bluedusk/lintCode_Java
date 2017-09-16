package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by openworld on 2017/9/10.
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s); // stack 转化为 list 再join输出！
        return "/" + String.join("/", list);
    }

    public static void main(String[] args){
        simplifyPath("/a/./b/../../c/d/");
    }
}
