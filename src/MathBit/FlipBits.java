package MathBit;

/**
 * Created by openworld on 2017/9/4.
 */
public class FlipBits {

    // 最简单方法： xor之后算出1的个数
    //
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        int a_xor_b = a ^ b;
        while (a_xor_b != 0) {
            ++count;
            a_xor_b &= (a_xor_b - 1); // 有几个1就有几个2的证书次幂
        }

        return count;
    }
}
