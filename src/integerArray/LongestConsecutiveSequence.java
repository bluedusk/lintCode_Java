package integerArray;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo on 2017/9/26.
 * 要求O(n)所以不能排序了；
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        // write you code here
        Set<Integer> set = new HashSet<>();
        for (int item : num) {
            set.add(item);
        }

        int ans = 0;
        for (int item : num) {
            if (set.contains(item)) {
                set.remove(item);

                int pre = item - 1;
                int next = item + 1;
                while (set.contains(pre)) {
                    set.remove(pre);
                    pre--;
                }
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                }
                ans = Math.max(ans, next - pre - 1);
            }
        }
        return ans;
    }
}
