package integerArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/29.
 */
public class ReorderArrayConstructNum {
    class Cmp implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String ab = a.concat(b);
            String ba = b.concat(a);
            return ba.compareTo(ab);
        }
    }
    public String minNumber(int[] nums) {
        // Write your code here
        int n = nums.length;
        if (n < 1) return "";

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Cmp());

        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
            ans = ans.concat(strs[i]);
        }

        // 处理0
        int i = 0;
        while (i < n && ans.charAt(i) == '0')
            i ++;

        if (i == n) return "0";
        return ans.substring(i);
    }

    //

}

