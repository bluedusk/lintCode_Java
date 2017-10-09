package integerArray;

/**
 * Created by Lenovo on 2017/10/2.
 */
public class ContainerWithMostWater {

        public int maxArea(int[] height) {
            int res = 0, i = 0, j = height.length - 1;
            while (i < j) {
                int h = Math.min(height[i], height[j]);
                res = Math.max(res, h * (j - i));
                while (i < j && h == height[i]) ++i;
                while (i < j && h == height[j]) --j;
            }
            return res;
        }

}
