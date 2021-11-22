package leetcode198;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 打家劫舍
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        int rob = new Solution().rob(nums);
        System.out.println(rob);

    }

    /**
     * 错误解法：不能计算奇偶索引位置的值；
     * 特例：[2,1,1,2]
     */
    public int rob1(int[] nums) {

        int q = 0;
        int w = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                q += nums[i];
            } else {
                w += nums[i];
            }
        }
        return Math.max(q, w);
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划：
     * @date 2021/11/22 14:49
     */
//    如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k (k>2)k~(k>2)k (k>2) 间房屋，有两个选项：
//
//    偷窃第 kkk 间房屋，那么就不能偷窃第 k−1k-1k−1 间房屋，偷窃总金额为前 k−2k-2k−2 间房屋的最高总金额与第 kkk 间房屋的金额之和。
//
//    不偷窃第 kkk 间房屋，偷窃总金额为前 k−1k-1k−1 间房屋的最高总金额。
//
//    在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 kkk 间房屋能偷窃到的最高总金额。
//
//    用 dp[i]\textit{dp}[i]dp[i] 表示前 iii 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
//
//    dp[i]=max⁡(dp[i−2]+nums[i],dp[i−1])\textit{dp}[i] = \max(\textit{dp}[i-2]+\textit{nums}[i], \textit{dp}[i-1]) dp[i]=max(dp[i−2]+nums[i],dp[i−1])
//
//    边界条件为：
//
//    {dp[0]=nums[0]只有一间房屋，则偷窃该房屋dp[1]=max⁡(nums[0],nums[1])只有两间房屋，选择其中金额较高的房屋进行偷窃\begin{cases} \textit{dp}[0] = \textit{nums}[0] & 只有一间房屋，则偷窃该房屋 \\ \textit{dp}[1] = \max(\textit{nums}[0], \textit{nums}[1]) & 只有两间房屋，选择其中金额较高的房屋进行偷窃 \end{cases} {dp[0]=nums[0]dp[1]=max(nums[0],nums[1])​只有一间房屋，则偷窃该房屋只有两间房屋，选择其中金额较高的房屋进行偷窃​
//
//        最终的答案即为 dp[n−1]\textit{dp}[n-1]dp[n−1]，其中 nnn 是数组的长度。
//
//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int rob(int[] nums) {

        // 状态方程：
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
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 长度大于2时
        // 状态方程填空
        for (int i = 2; i < length; i++) {
            // 填空
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[length - 1];
    }
}
