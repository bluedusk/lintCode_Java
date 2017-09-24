package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by openworld on 2017/9/24.
 * 其实应该用segment tree来做。
 */
public class CountOfSmallerNumber {

    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here

        Arrays.sort(A);
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if(A[j] < queries[i]){
                    count ++;
                }
            }
            list.add(count);

        }
        return list;
    }
}
