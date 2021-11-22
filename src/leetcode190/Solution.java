package leetcode190;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 颠倒二进制位
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    颠倒给定的 32 位无符号整数的二进制位。
//
//    提示：
//
//    请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//    在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
//
//
    public static void main(String[] args) {

        int n = 3;
//        int ret = new Solution().reverseBits(n);
        int ret = new Solution().reverseBits1(n);
        System.out.println(ret);

    }

    public int reverseBits(int n) {

        return Integer.reverse(n);
    }

    public int reverseBits1(int n) {

        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    /**
     * 分治：奇数偶数位交换
     */
    public int reverseBits2(int n) {

        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }


}