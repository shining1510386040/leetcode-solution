package leetcode509;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 计算斐波那契数列第n项
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {
    //
//    斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//    F(0) = 0，F(1) = 1
//    F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//
//    给你 n ，请计算 F(n) 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/fibonacci-number
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int n = 9;
        int fib = new Solution().fib(n);
        int fib1 = new Solution().fib1(n);
        System.out.println(fib);
        System.out.println(fib1);

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 垃圾写法之递归
     * @date 2021/11/19 14:46
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 动态规划：+ 滚动数组思想
     * 转态方程：F（n） = F（n-1）+F（n-2）
     * 边界值：F（0） = 0 ；F（1） =1
     * <p>
     * <p>
     * <p>
     * 时间复杂度：O(n)O(n)O(n)。
     * <p>
     * 空间复杂度：O(1)O(1)O(1)。
     * @date 2021/11/19 14:46
     */
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }


}
