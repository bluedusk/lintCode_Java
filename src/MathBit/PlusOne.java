package MathBit;

/**
 * Created by Lenovo on 2017/9/7.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        return plusDigit(digits, 1);
    }

    private int[] plusDigit(int[] digits, int digit) {
        if (digits == null || digits.length == 0) return null;

        // regard digit(0~9) as carry
        int carry = digit;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }

        // carry == 1
        if (carry == 1) {
            int[] finalResult = new int[result.length + 1];
            finalResult[0] = 1;
            return finalResult;
        }

        return result;
    }

}
