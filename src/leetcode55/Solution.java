package leetcode55;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 跳跃游戏
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个下标。
//
    public static void main(String[] args) {

//        int[] nums = {2,3,1,1,4};
        int[] nums = {3, 2, 1, 0, 4};
        boolean ret = new Solution().canJump(nums);
        System.out.println(ret);

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 贪心算法：
     * 设想一下，对于数组中的任意一个位置 yyy，我们如何判断它是否可以到达？根据题目的描述，只要存在一个位置 xxx，它本身可以到达，并且它跳跃的最大长度为 x+nums[x]x + \textit{nums}[x]x+nums[x]，这个值大于等于 yyy，即 x+nums[x]≥yx + \textit{nums}[x] \geq yx+nums[x]≥y，那么位置 yyy 也可以到达。
     * <p>
     * 换句话说，对于每一个可以到达的位置 xxx，它使得 x+1,x+2,⋯ ,x+nums[x]x+1, x+2, \cdots, x+\textit{nums}[x]x+1,x+2,⋯,x+nums[x] 这些连续的位置都可以到达。
     * <p>
     * 这样以来，我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 xxx，如果它在 最远可以到达的位置 的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x+nums[x]x + \textit{nums}[x]x+nums[x] 更新 最远可以到达的位置。
     * <p>
     * 在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直接返回 True 作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @date 2021/11/23 14:07
     */
    public boolean canJump(int[] nums) {

        int length = nums.length;
        // 最远可以到达的位置
        int rightmost = 0;

        for (int i = 0; i < length; i++) {
            if (i <= rightmost) {
                // 更新最远可以到达的位置
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= length - 1) {
                return true;
            }
        }
        return false;
    }
}
