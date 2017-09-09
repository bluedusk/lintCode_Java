package MathBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lenovo on 2017/9/6.
 *
 * 核心思想是33抵消；
 */
public class MajorityNumber2 {

    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1, count2;
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1 ++;
            } else if (candidate2 == nums.get(i)) {
                count2 ++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {  // 如果 nums(i) 不等于 candidate1 和 candidate2 则抵消；
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }
        return count1 > count2 ? candidate1 : candidate2;
    }

}
