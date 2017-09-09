package MathBit;

/**
 * Created by openworld on 2017/9/4.
 */
public class CheckPowerOf2 {

    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n < 1) {
            return false;
        } else {
            return (n & (n - 1)) == 0;
        }
    }
}
