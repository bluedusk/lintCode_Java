package string;

import java.util.*;

/**
 * Created by Lenovo on 2017/9/13.
 * http://www.lintcode.com/en/problem/rotate-words/
 */
public class RotateWords {

    /*
 * @param words: A list of words
 * @return: Return how many different rotate words
 */
    public static void main(String[] args){
        String[] s = {"picture", "turepic", "icturep", "word", "ordw", "lint"};
        String[] s1 = {"abba", "abab", "baba", "abab", "baba", "bbaa", "aabb"}; // 有重复word的情况，会删除自身导致结果一直为0
        String ss = rotateString("abba",3);
        countRotateWords(Arrays.asList(s1));
    }
    public static int countRotateWords(List<String> words) {
        // Write your code here
        HashSet set = new HashSet(words); // 使用set去重，在添加的时候会把words中的重复元素去掉；
        Iterator<String> iter = set.iterator(); // 使用iterator遍历，遍历时候可以删除元素；words是不变List不可以删除；
        while(iter.hasNext()){
            String s = iter.next();
            for (int i = 1; i < s.length(); i++) {
                String ss = rotateString(s,i);
                if(set.contains(ss) && !ss.equals(s)){ // set中存在s的rotate, 则删除自身； 有一种情况是旋转后等于自身比如aaa;要避免；
                    iter.remove();
                    break; // 注意这里需要break
                }
            }
        }
        return set.size();
    }

    public static String rotateString(String s, int offset) {
        char[] str = s.toCharArray();
        // write your code here
        if (str == null || str.length == 0)
            return "";

        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
        return new String(str);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
