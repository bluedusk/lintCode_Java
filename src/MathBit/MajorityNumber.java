package MathBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/6.
 *
 * 关键在于两两抵消
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72995
 */
public class MajorityNumber {

    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            // count == 0，之前的数已经全部抵消
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
