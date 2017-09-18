package hashtable;

import java.util.Hashtable;

/**
 * Created by Lenovo on 2017/9/14.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        Hashtable<Character, Integer> table = new Hashtable<Character,Integer>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)){
                table.put(c, table.get(c)+1);
            }else{
                table.put(c,1);
            }
        }
        // "aaaa"
        if (table.size() == 1){
            return table.get(s.charAt(0));
        }
        for (int item:
                table.values()) {
            if(item%2 == 0){
                result +=item; // 双数全部加入
            }else{
                result += item - 1; // 单数舍弃一位
            }
        }
        return result + 1;

    }
}
