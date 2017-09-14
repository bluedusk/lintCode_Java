package MathBit;

/**
 * Created by openworld on 2017/9/7.
 * http://www.lintcode.com/en/problem/add-digits/
 */
public class AddDigits {

/*
 * @param num: a non-negative integer
 * @return: one digit
 */
    public static int addDigits(int num) {
        // write your code here
        if(num<10){
            return num;
        }
        int result = 0;
        while(num != 0){
            result += num % 10;
            num = num / 10;
        }
        return addDigits(result);
    }

    public static int addDigits2(int num) {
        // write your code here
        return (num - 1) % 9 + 1;

    }

    public static void main(String[] args){
        int x = addDigits(138);
        System.out.println(x);
    }


}
