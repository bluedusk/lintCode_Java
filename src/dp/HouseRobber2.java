package dp;

/**
 * Created by Lenovo on 2017/10/12.
 */
public class HouseRobber2 {

    public int houseRobber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));
    }

    // dp 求house robber1结果
    public int robber(int[] nums, int st, int ed) {
        // 这里不用整个数组，节省空间
        int []res = new int[2];
        if(st == ed)
            return nums[ed];
        if(st+1 == ed)
            return Math.max(nums[st], nums[ed]);
        res[st%2] = nums[st];
        res[(st+1)%2] = Math.max(nums[st], nums[st+1]);

        for(int i = st+2; i <= ed; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + nums[i]);

        }
        return res[ed%2];
    }

}
