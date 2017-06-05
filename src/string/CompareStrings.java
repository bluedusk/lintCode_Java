package string;

/**
 * Created by Lenovo on 2017/5/24.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72935
 */
public class CompareStrings {
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A.length() < B.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
            count[(int) A.charAt(i)-'A']++;
        }
        for (int i = 0; i < B.length(); i++) {
            count[(int) B.charAt(i)-'A']--;
            if (count[(int) B.charAt(i)-'A'] < 0) {
                return false;
            }
        }
        return true;
    }

}
