package leetcode45;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 跳跃游戏-获取最小的跳跃次数
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//    假设你总是可以到达数组的最后一个位置。
//
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        int ret = new Solution().jump(nums);
        int ret1 = new Solution().jump1(nums);
        System.out.println(ret);
        System.out.println(ret1);

    }

    /**
     * 贪心算法: 反向查找位置
     */
    public int jump(int[] nums) {
        // 最后一次跳跃的下标位置
        int position = nums.length - 1;
        // 跳跃次数
        int steps = 0;
        while (position > 0) {

            for (int i = 0; i < position; i++) {
                // 反向推
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    // 跳出本次for
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 贪心算法：正向推
     * @date 2021/11/23 14:57
     */
    public int jump1(int[] nums) {

        int length = nums.length;
        // 本次跳跃的最远距离
        int end = 0;
        // 右跳的最大位置
        int maxPosition = 0;
        // 步数
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
