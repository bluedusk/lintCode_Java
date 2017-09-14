package string;

/**
 * Created by Lenovo on 2017/9/11.
 */
public class LengthOfLongestSubstring {
    // 审题错误，写成最长重复string的length了
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        char[] c = s.toCharArray();
        int x = 0, y = 1, result = 1, tmp = 1;
        for (int i = 1; i < c.length; i++) {
            if(c[i] == c[i-1]){
                tmp++;
            }
            else{
                x = i;
                result = Math.max(result,tmp);
                tmp = 1;
            }
        }
        return result;
    }

    // 双指针 i,j
    public static int lengthOfLongestSubstring1(String s) {
        // write your code here
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        // map[index] == 0 表示字母没有出现过
        // map[index] == 1
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            //
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }

        return ans;
    }

    public static void main(String[] args){
        lengthOfLongestSubstring1("abcadcbb");
        //lengthOfLongestSubstring1("ddaaa123");
    }
}
