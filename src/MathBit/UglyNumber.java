package MathBit;

/**
 * Created by Lenovo on 2017/9/6.
 */
public class UglyNumber {

    // TLE
    public boolean isUgly(int num) {
        // write your code here

        while(num%2 == 0 || num%3 == 0 || num%5 == 0){

            if(num == 2 || num == 3 || num == 5){
                return true;
            }

            if(num%2 == 0){
                num = num / 2;
            }
            if(num%3 == 0){
                num = num / 3;
            }
            if(num%5 == 0){
                num = num / 5;
            }
        }

        return false;
    }

    public boolean isUgly2(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        while (num >= 2 && num % 2 == 0) num /= 2;
        while (num >= 3 && num % 3 == 0) num /= 3;
        while (num >= 5 && num % 5 == 0) num /= 5;

        return num == 1;
    }
}
