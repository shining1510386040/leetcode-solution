package leetcode213;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 打家劫舍2：房屋首位相连
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        int rob = new Solution().rob(nums);
        System.out.println(rob);

    }

    public int rob(int[] nums) {

        // 状态方程：是否偷第一家 【0，end-2】
        // 边界条件
        // dp[i] 偷窃前i个房间的最大金额
        int length = nums.length;
        int[] dp = new int[length];
        // 边界条件
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 长度大于2时
        for (int i = 2; i < length; i++) {
            // 填空
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            // 是否偷第一家
            int ret1 = robRange(nums, 0, length - 2);
            int ret2 = robRange(nums, 1, length - 1);
            dp[i] = Math.max(ret1, ret2);
        }

        return dp[length - 1];
    }

    private int robRange(int[] nums, int start, int end) {

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end];

    }
}
