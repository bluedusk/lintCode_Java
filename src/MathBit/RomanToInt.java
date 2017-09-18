package MathBit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by openworld on 2017/9/10.
 * http://www.cnblogs.com/grandyang/p/4120857.html
 */
public class RomanToInt {
    /*
    * @param s: Roman representation
    * @return: an integer
    */

    public static void main(String[] args){
        romanToInt("XCIX");
    }
    public static int romanToInt(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int length = s.length();
        int result = m.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
                result += m.get(s.charAt(i));
            } else {
                result -= m.get(s.charAt(i));
            }
        }
        return result;
    }

    public int romanToInt1(String s) {
        // Write your code here
        int ans;
        char[] sc = s.toCharArray();
        ans = toInt(sc[0]);                        //0 special
        for (int i = 1; i < s.length(); i++) {
            ans += toInt(sc[i]);
            if (toInt(sc[i - 1]) < toInt(sc[i])) {
                ans -= toInt(sc[i - 1]) * 2;
            }
        }
        return ans;
    }

    int toInt(char s) {
        switch(s) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
}
