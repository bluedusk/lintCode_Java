package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/20.
 * http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
 * http://www.jiuzhang.com/solutions/palindrome-partitioning-ii/
 *
 * 递归的实现效率太低，Time Exceeded
 *
 */
public class PalindromePartitioning2 {

    /**
     * @param s a string
     * @return an integer
     */
    public static int minCut(String s) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        result.add(s.length()-1);
        if (s == null || s.isEmpty()) return 0;

        List<String> palindromes = new ArrayList<String>();
        dfs(s, 0, palindromes, result);

        return result.get(0);
    }

    private static void dfs(String s, int pos, List<String> palindromes,
                            List<Integer> result) {

        if (pos == s.length()) {
            result.set(0,Math.min(result.get(0), palindromes.size()-1));
        }
        // 大循环：i = 隔板位置循环
        for (int i = pos + 1; i <= s.length(); i++) {
            String substr = s.substring(pos, i);
            if (!isPalindrome(substr)) {
                continue;
            }
            // 如果是隔板前的string如果是回文加入回文list
            palindromes.add(substr);
            // 对隔板后的string开始递归调用dfs
            dfs(s, i, palindromes, result);
            // 回溯法，删除本轮添加的回文, 下个循环隔板前进重新开始
            palindromes.remove(palindromes.size() - 1);
        }
    }
    private static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;
    }

    public static void main(String[] args){
        int x = minCut("ababababababababababababcbabababababababababababa");
        System.out.println(x);
    }
}
