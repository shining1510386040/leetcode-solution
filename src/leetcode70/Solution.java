package leetcode70;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 爬楼梯
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//    注意：给定 n 是一个正整数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/climbing-stairs
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int n = 2;
        int ret = new Solution().climbStairs(n);
        System.out.println(ret);

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划
     * @date 2021/11/22 10:13
     */
    public int climbStairs(int n) {

        // f(x) = f(x-1)+f(x-2)
        // 最后一次爬台阶可能爬一个台阶或者两个台阶；
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划+滚动数组
     * @date 2021/11/22 11:12
     */
    public int climbStairs1(int n) {

        // f(x) = f(x-1)+f(x-2)
        // 最后一次爬台阶可能爬一个台阶或者两个台阶；
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
