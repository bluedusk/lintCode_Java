package string;

/**
 * Created by openworld on 2017/9/9.
 */
public class PalindromeNumber {

    /*
 * @param num: a positive number
 * @return: true if it's a palindrome or false
 */
    public static boolean isPalindrome(int x) {
        // 数学解法//
        //解题思路: 这道题很明显是一道数学题,计算一个数字是否是回文数字，
        // 我们其实就是将这个数字除以10，保留他的余数，
        // 下次将余数乘以10，加上这个数字再除以10的余数.

        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        else
        {
            int tmp = x;
            int y = 0;
            while(x != 0)
            {
                y = y*10 + x%10;
                x = x/10;
            }
            if(y == tmp)
                return true;
            else
                return false;
        }


    }

    public static void main(String[] args){
        isPalindrome(12321);
    }
}
