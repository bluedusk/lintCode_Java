package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by openworld on 2017/9/17.
 */


    /**
     * Created by openworld on 2017/9/17.
     */
    class RandomizedSet1 {

        ArrayList<Integer> nums;
        HashMap<Integer, Integer> m;
        Random rand;

        public RandomizedSet1() {
            // do initialize if necessary
            nums = new ArrayList<Integer>();
            m = new HashMap<Integer, Integer>();
            rand = new Random();
        }

        // Inserts a value to the set
        // Returns true if the set did not already contain the specified element or false
        public boolean insert(int val) {
            // Write your code here
            boolean contain = nums.contains(val);
            if ( contain ) return false;
            nums.add(val);
            return true;
        }

        // Removes a value from the set
        // Return true if the set contained the specified element or false
        public boolean remove(int val) {
            // Write your code here
            boolean contain = nums.contains(val);
            if ( ! contain ) return false;
            Integer i = val;
            nums.remove(i);
            return true;
        }

        // Get a random element from the set
        public int getRandom() {
            // Write your code here
            return nums.get(rand.nextInt(nums.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */

