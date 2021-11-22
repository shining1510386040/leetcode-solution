package leetcode53;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 最大子序列和
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));


    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 双指针：错误解法（）
     * @date 2021/11/19 15:21
     */
    @Deprecated
    public int maxSubArray(int[] nums) {

        int max = 0;
        for (int left = 0; left < nums.length; left++) {

            for (int right = left + 1; right < nums.length; right++) {
                int p = left;
                int cur = 0;
                while (p < right) {
                    cur += nums[p++];
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划：太难理解了
     * @date 2021/11/19 15:54
     */
    public int maxSubArray1(int[] nums) {
        // pre 前j 个数组元素的最大子序列的和
        // pre = max{pre,nums[j]}
        int pre = 0;
        int maxAns = nums[0];
        for (int j = 0; j < nums.length; j++) {
            // nums[j] 加入pre 成为一段，or nums[j] 单独成为一段
            pre = Math.max(pre + nums[j], nums[j]);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }


}
