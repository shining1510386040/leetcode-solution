package leetcode746;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 使用最小的花费爬楼梯
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
//
//    每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
//
//    请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int re = new Solution().minCostClimbingStairs(cost);
        System.out.println(re);

    }

    //
//    假设数组 cost\textit{cost}cost 的长度为 nnn，则 nnn 个阶梯分别对应下标 000 到 n−1n-1n−1，楼层顶部对应下标 nnn，问题等价于计算达到下标 nnn 的最小花费。可以通过动态规划求解。
//
//    创建长度为 n+1n+1n+1 的数组 dp\textit{dp}dp，其中 dp[i]\textit{dp}[i]dp[i] 表示达到下标 iii 的最小花费。
//
//    由于可以选择下标 000 或 111 作为初始阶梯，因此有 dp[0]=dp[1]=0\textit{dp}[0]=\textit{dp}[1]=0dp[0]=dp[1]=0。
//
//    当 2≤i≤n2 \le i \le n2≤i≤n 时，可以从下标 i−1i-1i−1 使用 cost[i−1]\textit{cost}[i-1]cost[i−1] 的花费达到下标 iii，或者从下标 i−2i-2i−2 使用 cost[i−2]\textit{cost}[i-2]cost[i−2] 的花费达到下标 iii。为了使总花费最小，dp[i]\textit{dp}[i]dp[i] 应取上述两项的最小值，因此状态转移方程如下：
//
//    dp[i]=min⁡(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])\textit{dp}[i]=\min(\textit{dp}[i-1]+\textit{cost}[i-1],\textit{dp}[i-2]+\textit{cost}[i-2]) dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
//
//    依次计算 dp\textit{dp}dp 中的每一项的值，最终得到的 dp[n]\textit{dp}[n]dp[n] 即为达到楼层顶部的最小花费。
//
    public int minCostClimbingStairs(int[] cost) {
        // dp(i) 到达第i个阶梯的最小花费
        int length = cost.length;
        int[] dp = new int[length + 1];
        if (length < 2) {
            // dp（0）= dp（1） = 0
            dp[0] = dp[1] = 0;
        }
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }


        return dp[length];
    }

}
