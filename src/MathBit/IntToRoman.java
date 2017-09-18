package MathBit;

/**
 * Created by Lenovo on 2017/9/11.
 * http://www.lintcode.com/en/problem/integer-to-roman/
 * http://www.cnblogs.com/grandyang/p/4123374.html
 */
public class IntToRoman {

    /*
 * @param n: The integer
 * @return: Roman representation
 */
    public static void main(String[] args){
        intToRoman(3999);
    }
    // solution 1 通用版
    public static String intToRoman(int num) {
        String res = "";
        char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int value[] = {1000, 500, 100, 50, 10, 5, 1};
        // value.length == 7
        for (int n = 0; n < 7; n += 2) {
            // 计算千百十位
            int x = num / value[n];
            // 如果小于四则累加， 如3000则 MMM
            if (x < 4) {
                for (int i = 1; i <= x; ++i) res += roman[n];
            }
            // 如果等于4， 则放左侧，如4为 IV
            else if (x == 4) res = res + roman[n] + roman[n - 1];
            // 如果是 5-8 ， 则放右侧，如5678为 V,VI,VII,VIII
            else if (x > 4 && x < 9) {
                res += roman[n - 1];
                for (int i = 6; i <= x; ++i) res += roman[n];
            }
            // 如果是9 放左侧， 如9为 IX
            else if (x == 9) res = res + roman[n] + roman[n - 2];
            // 计算后取余继续下一轮计算
            num %= value[n];
        }
        return res;
    }

    // 限定千位数，简化版
    public String intToRoman1(int num) {
        String res = "";
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < val.length; ++i) {
            while (num >= val[i]) {
                num -= val[i];
                res += str[i];
            }
        }
        return res;
    }

    // 暴力字典法，因为限定 3999 可以这么做
    public String intToRoman2(int num) {
        String res = "";
        String[] v1 = {"", "M", "MM", "MMM"}; // {0, 1000, 2000, 3000}
        String[] v2 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // {0, 100 -- 900}
        String[] v3 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // {0, 10 -- 90}
        String[] v4 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // {0, 1 -- 9}
        return v1[num / 1000] + v2[(num % 1000) / 100] + v3[(num % 100) / 10] + v4[num % 10];
    }
    }
