package string;

/**
 * Created by Lenovo on 2017/5/24.
 * http://www.lintcode.com/zh-cn/problem/two-strings-are-anagrams/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72934
 */
public class Anagrams {

    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        int[] count = new int[256];
        for (int i = 0; i < length; i++) {
            count[(int) s.charAt(i)]++;
            count[(int) t.charAt(i)]--;
        }
        for (int i = 0; i < length; i++) {
            if (count[(int) t.charAt(i)] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "aab";
        String t = "aba";

        anagram(s,t);
    }
}
