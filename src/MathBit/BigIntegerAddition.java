package MathBit;

/**
 * Created by Lenovo on 2017/9/7.
 */
public class BigIntegerAddition {

    /*
 * @param num1: a non-negative integers
 * @param num2: a non-negative integers
 * @return: return sum of num1 and num2
 *
 * 注意char和int
 * char数组和string之间的转换
 *
 */
    public static String addStrings(String num1, String num2) {
        // write your code here
        if(num1.length() < num2.length()){
            return addStrings(num2,num1);
        }
        char[] num1Chars =  num1.toCharArray() ;
        char[] num2Chars =  num2.toCharArray();

        int carry = 0;
        char[] result = new char[num1Chars.length];
        for (int i = num1.length() - 1; i >= 0 ; i--) {
            int x = num1Chars[i] - 48;
            int y = i < num1.length() - num2.length() ? 0 : num2Chars[i-(num1.length() - num2.length())] - 48;
            int z = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            result[i] = (char) (z + 48);
        }
        if(carry == 1){
            char[] newResult = new char[num1Chars.length + 1];
            newResult[0] = '1';
            for (int i = 1; i < num1Chars.length + 1; i++) {
                newResult[i] = result[i-1];
            }
            return new String(newResult);
        }

        return new String(result);


    }

    public static void main(String[] args){

        addStrings("123", "45");

    }
}
