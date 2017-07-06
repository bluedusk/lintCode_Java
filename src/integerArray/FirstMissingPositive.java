package integerArray;

/**
 * Created by Lenovo on 2017/6/14.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72954
 */
public class FirstMissingPositive {

    /*
    * A few quick thoughts:

    Sort all numbers and iterate through to find the first missing integer? No, most sorting algorithms take time at least O(nlogn).
    How about linear sorting algorithm? No, bucket sort requires O(n) space.
    Mapping all positive integers to a hash table and iterate from 1 to the length of the array to find out the first missing one? No, hash table requires O(n) space.

    Then, how to solve this?

    Let's take another look at the problem. It is asking for the first missing POSITIVE integer.
    So, given a number in the array,

    if it is non-positive, ignore it;
    if it is positive, say we have A[i] = x, we know it should be in slot A[x-1]!
    That is to say, we can swap A[x-1] with A[i] so as to place x into the right place.
    We need to keep swapping until all numbers are either non-positive or in the right places.
    The result array could be something like [1, 2, 3, 0, 5, 6, ...].
    Then it's easy to tell that the first missing one is 4 by iterate through the array and compare each value with their index.
    */

    // SOLUTION 2:
    public int firstMissingPositive(int[] A) {
        // bug 3: when length is 0, return 1;
        if (A == null) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            // 1: A[i] is in the range;
            // 2: A[i] > 0.
            // 3: The target is different;
            while (A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        //
        return A.length + 1;
    }

    public void swap(int[] A, int l, int r) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}
