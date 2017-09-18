package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo on 2017/9/12.
 */
public class WordBreak {


    // 递归，堆栈溢出
    public static boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s.length() == 0){
            return true;
        }
        if (dict.contains(s)){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0,i);
            if (dict.contains(s1)){
                return wordBreak(s.substring(i), dict);
            }
        }
        return false;
    }
    // 一维DP问题
    public static boolean wordBreak1(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return true;
        if (dict == null || dict.isEmpty()) return false;

        // get the max word length of wordDict
        int max_word_len = 0;
        for (String word : dict) {
            max_word_len = Math.max(max_word_len, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // optimize for too long interval
                if (i - j > max_word_len) break;

                String word = s.substring(j, i);
                if (dp[j] && dict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
    public static void main(String[] args){
        HashSet<String> s = new HashSet<String>();
        s.add("aa");
        s.add("ab");
        wordBreak("aaab",s);
    }
}
