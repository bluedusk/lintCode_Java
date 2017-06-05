package string;

/**
 * Created by Lenovo on 2017/6/5.
 * http://www.lintcode.com/en/problem/longest-palindromic-substring/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72941
 */
public class LongestPalindrome {

    // 穷举法搜索
    public String longestPalindrome(String s) {
        // Write your code here
        String result = new String();
        if (s == null || s.isEmpty()) return result;

        int n = s.length();
        int longest = 0, left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substr = s.substring(i, j);
                if (isPalindrome(substr) && substr.length() > longest) {
                    longest = substr.length();
                    left = i;
                    right = j;
                }
            }
        }

        result = s.substring(left, right);
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;
    }

    /*
    题意为求最长回文子串， 直接枚举子串首尾位置再判断是否会问，时间复杂度为O(N^3)，
    换个思路，枚举回文串的对称中心位置，向两侧扫描检测最长回文长度时间复杂度为O(N^2)
    对于最长回文子串问题有对应O(N)算法--Manacher算法
    笔者觉得面试中应当不会有这么高的要求，有兴趣可以自行了解该算法
    */

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            // 字符串被构造成："#a#b#c#d#z#d#c#a#b#"
            // i/2 是当前字符
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }

        return result;
    }
    // 将原字符串扩展成#a#b#的形式可以直接枚举长度，不用考虑回文串长度的奇偶性
    // 字符串被构造成："#a#b#c#d#z#d#c#a#b"
    private static char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else
            return s.charAt(i / 2);
    }

    public static void main(String[] args){
        String s = "abcdzdcab";
        longestPalindrome1(s);
    }
}
