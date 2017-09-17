package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by openworld on 2017/9/17.
 */
 class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> m;
    Random rand;

    public RandomizedSet() {
        // do initialize if necessary
        nums = new ArrayList<Integer>();
        m = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        // Write your code here
        boolean contain = m.containsKey(val);
        if ( contain ) return false;
        m.put( val, nums.size());
        nums.add(val); // 插入总是最后，复杂度O(1)
        return true;
    }

    // Removes a value from the set
    // Return true if the set contained the specified element or false
    // List删除任意元素的复杂度不是o(1)因此需要删除最后元素；
    public boolean remove(int val) {
        // Write your code here
        boolean contain = m.containsKey(val);
        if ( ! contain ) return false;
        int loc = m.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            m.put(lastone, loc);
        }
        m.remove(val);
        nums.remove(nums.size() - 1);
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