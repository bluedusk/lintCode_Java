package binarySearch;

/**
 * Created by openworld on 2017/9/3.
 */
public class Sqrt {

    /*
 * @param x: An integer
 * @return: The sqrt of x
 */
    public int sqrt(int x) {
        // write your code here

        if(x < 0){
            return -1;
        }
        if(x == 0){
            return 0;
        }

        // 注意long, 否则mid会超int
        long start = 1, end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}
