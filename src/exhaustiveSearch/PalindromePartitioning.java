package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/20.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73059
 * http://www.jiuzhang.com/solutions/palindrome-partitioning/
 *
 * 递归+回溯法
 * 九章有个更好解法
 *
 */
public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.isEmpty()) return result;

        List<String> palindromes = new ArrayList<String>();
        dfs(s, 0, palindromes, result);

        return result;
    }
    private void dfs(String s, int pos, List<String> palindromes,
                     List<List<String>> ret) {

        if (pos == s.length()) {
            ret.add(new ArrayList<String>(palindromes));
            return;
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
            dfs(s, i, palindromes, ret);
            // 回溯法，删除本轮添加的回文, 下个循环隔板前进重新开始
            palindromes.remove(palindromes.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;
    }

}
