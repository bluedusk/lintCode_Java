package hashTable;

import java.util.*;

/**
 * Created by openworld on 2017/9/16.
 */
public class IntersectionTwoArrays2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1.length < nums2.length) {
            return intersection(nums2, nums1);
        }
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!table.containsKey(nums1[i])) {
                table.put(nums1[i], 1);
            }
            else{
                table.put(nums1[i],table.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (table.containsKey(nums2[i]) && table.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                table.put(nums2[i],table.get(nums2[i]) - 1);

            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (Integer i : list) {
            result[k++] = i;
        }

        return result;
    }
}
