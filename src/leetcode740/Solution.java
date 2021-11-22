package leetcode740;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 删除并获得点数
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给你一个整数数组 nums ，你可以对它进行一些操作。
//
//    每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
//
//    开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/delete-and-earn
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 3, 3, 4};
        int rob = new Solution().deleteAndEarn(nums);
        System.out.println(rob);

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划：转化为小偷偷钱获得最多钱数的问题（leetcode198 打家劫舍 偷到最多钱数，不能相邻）
     * @date 2021/11/22 16:39
     */
    public int deleteAndEarn(int[] nums) {

        // 构造一个sums数组，数组i位置存储 数字i 出现的点数和
        // nums数组中的最大值
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] sums = new int[maxVal + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // nums数组 相同元素出现 个数的和
            sums[num] += num;
        }
        // 打家劫舍问题
        int ret = rob(sums);
        return ret;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 打家劫舍问题：相邻不能偷
     * @date 2021/11/22 16:48
     */
    private int rob(int[] sums) {

        int length = sums.length;
        if (length == 1) {
            return sums[0];
        }
        if (length == 2) {
            return Math.max(sums[0], sums[1]);
        }
        int first = sums[0];
        int second = Math.max(sums[0], sums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            // 是否打劫最后一家，
            second = Math.max(first + sums[i], second);
            first = temp;
        }
        return second;
    }

}
