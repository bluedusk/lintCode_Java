package dp;

/**
 * Created by openworld on 2017/9/9.
 */
public class DecodeWays {

    /*
 * @param s: a string,  encoded message
 * @return: an integer, the number of ways decoding
 */
    public static void main(String[] args){
        numDecodings0("123156");
    }
    // 不太好理解，用例子
    public static int numDecodings0(String s) {

        if(s.length() == 0) return s.length();
        int[] dp = new int[s.length() + 1];
        // 初始化第一种解码方式
        dp[0] = 1;
        // 如果第一位是0，则无法解码
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // dp 数组
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }

            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];
    }


// version: 高频题班

    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings2(String s) {
        // Write your code here
        int l = s.length();
        if (l == 0) {
            return 0;   // only for this problem, but the ans should be 1
        }
        int[] f = new int[l + 1];
        f[0] = 1;
        char sc[] = s.toCharArray();

        for (int i = 1; i <= l; i++) {
            if (sc[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                int val2 = (sc[i - 2] - '0') * 10 + sc[i - 1] - '0';
                if (10 <= val2 && val2 <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[l];
    }


}
