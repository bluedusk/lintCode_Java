package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/10/4.
 */
public class Candy {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        // 初始化每个人一个糖果
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        int sum = 0;

        // 第一遍从左向右遍历，如果右边的小盆友的等级高，等加一个糖果，这样保证了一个方向上高等级的糖果多。
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        // 然后再从右向左遍历一遍，如果相邻两个左边的等级高，而左边的糖果又少的话，则左边糖果数为右边糖果数加一。
        for(int i = ratings.length - 1; i >= 1; i--) {
            sum += count[i];
            if(ratings[i - 1] > ratings[i] && count[i - 1] <= count[i]) {  // second round has two conditions
                count[i-1] = count[i] + 1;
            }
        }
        // 最后再把所有小盆友的糖果数都加起来返回即可
        sum += count[0];
        return sum;
    }
}
