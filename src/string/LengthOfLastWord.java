package string;

/**
 * Created by Lenovo on 2017/6/8.
 * http://www.lintcode.com/en/problem/length-of-last-word/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72944
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        int index = s.lastIndexOf(" ");
        String result = s.substring(index + 1);
        return result.length();
    }

    public static void main(String[] args){
        lengthOfLastWord("Hello World ");
    }

}
