package string;

/**
 * Created by Lenovo on 2017/9/14.
 */
public class SortLettersbyCase {

    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        char tmp ;
        // 双指针扫描，相遇则结束
        while ( i <= j) {
            while (i <= j && Character.isLowerCase(chars[i]) ) i++;
            while (i <= j && Character.isUpperCase(chars[j]) ) j--;
            if (i <= j) {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++; j--;
            }
        }
        //write your code here
        return ;
    }
}
