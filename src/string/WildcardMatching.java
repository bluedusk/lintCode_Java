package string;

import java.util.TreeSet;

/**
 * Created by Lenovo on 2017/6/7.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72943
 */
public class WildcardMatching {

    // Solution1: TLE
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0|| p.length() == 0) return false;

        return helper(s, 0, p, 0);
    }

    private static boolean helper(String s, int si, String p, int pj) {
        // index out of range check
        if (si == s.length() || pj == p.length()) {
            if (si == s.length() && pj == p.length()) {
                return true;
            }
            else{
               // s="a"   p="a****"
             if(si == s.length() && pj != p.length()) {
                 if (p.charAt(pj) == '*') {
                     // remove coninuous *
                     while (p.charAt(pj) == '*') {
                         pj++;
                         // index out of range check
                         if (pj == p.length()) return true;
                     }
                 }
             }
                return false;
            }
        }

        if (p.charAt(pj) == '*') {
            // remove coninuous *
            while (p.charAt(pj) == '*') {
                pj++;
                // index out of range check
                if (pj == p.length()) return true;
            }

            // compare remaining part of p after * with s
            while (si < s.length() && !helper(s, si, p, pj)) {
                si++;
            }
            // substring of p equals to s
            return si != s.length();
        } else if (s.charAt(si) == p.charAt(pj) || p.charAt(pj) == '?') {
            return helper(s, si + 1, p, pj + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        String s = "a";
        String p = "a*";

        isMatch(s,p);
    }
    // solution2: OK

    public boolean isMatch2(String s, String p) {
        // without this optimization, it will fail for large data set
        int plenNoStar = 0;
        for (char c : p.toCharArray())
            if (c != '*') plenNoStar++;
        if (plenNoStar > s.length()) return false;

        s = " " + s;
        p = " " + p;
        int slen = s.length();
        int plen = p.length();

        boolean[] dp = new boolean[slen];
        TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
        firstTrueSet.add(0);
        dp[0] = true;

        boolean allStar = true;
        for (int pi = 1; pi < plen; pi++) {
            if (p.charAt(pi) != '*')
                allStar = false;
            for (int si = slen - 1; si >= 0; si--) {
                if (si == 0) {
                    dp[si] = allStar ? true : false;
                } else if (p.charAt(pi) != '*') {
                    if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') dp[si] = dp[si-1];
                    else dp[si] = false;
                } else {
                    int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE : firstTrueSet.first();
                    if (si >= firstTruePos) dp[si] = true;
                    else dp[si] = false;
                }
                if (dp[si]) firstTrueSet.add(si);
                else firstTrueSet.remove(si);
            }
        }
        return dp[slen - 1];
    }
    // solution3: easy 贪心算法
    // 一个比较好的算法是贪心算法（greedy）:
    // whenever encounter ‘*’ in p, keep record of the current position of ‘*’ in p and the current index in s.
    // Try to match the stuff behind this ‘*’ in p with s, if not matched, just s++ and then try to match again.
    // 关键在于处理s和出现*后的模式匹配，和回溯。
    public boolean isMatch3(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int sIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            //遇到'*'则记录p和s当前位置
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                sIndex = i;
                j++;
            //这一步是关键，匹配s中当前字符与p中'*'后面的字符，如果匹配，则在第一个if中处理，如果不匹配，则继续比较s中的下一个字符。
            //如果*后匹配失败，j回到保存的startIndex后一位，i回到保存的sIndex后一位；然后开始继续比较；
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = sIndex+1;
                sIndex++;
            } else {
                return false;
            }
        }
        //最后在此处处理多余的‘*’，因为多个‘*’和一个‘*’意义相同。
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }

        return j == p.length();
    }
}
