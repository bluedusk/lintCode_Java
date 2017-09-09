package MathBit;

/**
 * Created by Lenovo on 2017/9/5.
 */
public class CountOnes {

    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }
}
