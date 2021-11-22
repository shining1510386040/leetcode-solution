package leetcode1137;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 计算泰波那契数列第n项
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    泰波那契序列 Tn 定义如下：
//
//    T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//    给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int n = 4;
        System.out.println(new Solution().tribonacci(n));
        System.out.println(new Solution().tribonacci1(n));

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 递归
     * @date 2021/11/19 14:57
     */
    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        } else {
            return tribonacci(n - 2) + tribonacci(n - 1) + tribonacci(n - 3);
        }

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划+滚动数组
     * @date 2021/11/19 15:00
     */
    public int tribonacci1(int n) {

        if (n == 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        } else if (n >= 3) {
            int q = 0, w = 0, e = 1;
            int r = 1;
            for (int i = 3; i <= n; i++) {
                q = w;
                w = e;
                e = r;
                r = q + w + e;
            }
            return r;
        } else {
            return -1;
        }

    }


}
