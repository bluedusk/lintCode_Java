package hashTable;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by openworld on 2017/9/16.
 * http://www.jiuzhang.com/solution/intersection-of-two-arrays
 * 三种实现方式：
 * 1. 双指针扫描
 * 2. hashtable
 * 3. sort+binarySearch
 */
public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if(nums1.length < nums2.length){
            return intersection(nums2,nums1);
        }
        Hashtable<Integer,Integer> table = new Hashtable<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if(!table.containsKey(nums1[i])){
                table.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(table.containsKey(nums2[i])){
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer i : set) {
            result[k++] = i;
        }

        return result;

    }
}
