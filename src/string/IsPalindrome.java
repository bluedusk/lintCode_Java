package string;

/**
 * Created by Lenovo on 2017/6/1.
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        // Write your code here

        char[] cArray = s.toCharArray();
        int length = cArray.length;
        int left = 0;
        int right = length - 1;
        while(right>left){
            if(!Character.isLetterOrDigit(cArray[left])){
                left ++;
                continue;
            }
            if(!Character.isLetterOrDigit(cArray[right])){
                right --;
                continue;
            }
            if(Character.toLowerCase(cArray[left]) != Character.toLowerCase(cArray[right])){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }
}
