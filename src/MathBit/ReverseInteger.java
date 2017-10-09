package MathBit;

/**
 * Created by Lenovo on 2017/10/4.
 */
public class ReverseInteger {

    public static int reverseInteger(int n) {
        int reversed_n = 0;

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str1 = "";
        int i = 12345;


        reverseInteger(i);


    }
}
