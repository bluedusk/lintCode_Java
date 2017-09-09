package MathBit;

/**
 * Created by Lenovo on 2017/9/6.
 */
public class DigitCounts {

    public int digitCounts(int k, int n) {
        // write your code here


        int count = 0;
        char kChar = (char)(k + '0');
        for (int i = k; i <= n; i++) {
            char[] iChars = Integer.toString(i).toCharArray();
            for (char iChar : iChars) {
                if (kChar == iChar) count++;
            }
        }

        return count;
    }

    public static void main(String[] args){

        System.out.println(14%3);
    }
}
