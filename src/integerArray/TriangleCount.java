package integerArray;

import java.util.Arrays;

/**
 * Created by Lenovo on 2017/10/10.
 * Lintcode上的一道题目，刚开始看到并没有什么思路，仔细分析下还是可以看到解题思路的。
 * 已知三条边a,b,c，则判断它们能不能组成三角形的条件是：a + b> c&& a + c > b && b + c > a。约束条件还是非常多的。
 * 但是如果 a,b,c已经排序，比如a<b<c, 则只需判断a+b > c。大大简化约束。
   所以这题可以对数组先进行排序。

 之后我们相对固定第三条边，然后用双指针进行另外两条边的扫描，寻找a + b > c的 <a,b> pair。这步其实就是Two Sum II 所要做的事情。
 从右往左扫第三条边，在其左边的数组用双指针查找合格pair。代码如下：
 */
public class TriangleCount {

    public int triangleCount(int[] S) {
        // write your code here
        Arrays.sort(S);
        int result = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while(left < right){
                // triangle
                if(S[left] + S[right] > S[i]){
                    result += right - left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {3,4,6,7};
        int[][] AA = {};
        String str1 = "";

        TriangleCount x = new TriangleCount();
        x.triangleCount(A);

    }

}
