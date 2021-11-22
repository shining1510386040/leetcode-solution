package test;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 测试二进制位运算
 * @date 2021/11/18 18:57
 * @see
 */
public class BinMainTest {

    public static void main(String[] args) {

        // 非运算
        System.out.println("8的二进制：" + Integer.toBinaryString(8));
        System.out.println("8取反后的二进制：" + Integer.toBinaryString(~8));
        System.out.println();

        // 与运算
        System.out.println("12的二进制：" + Integer.toBinaryString(12));
        System.out.println("2的二进制：" + Integer.toBinaryString(2));
        System.out.println("12和2与运算后" + Integer.toBinaryString(12 & 2));
        System.out.println();

        // 或运算
        System.out.println("12的二进制：" + Integer.toBinaryString(12));
        System.out.println("2的二进制：" + Integer.toBinaryString(2));
        System.out.println("12和2或运算后" + Integer.toBinaryString(12 | 2));
        System.out.println();

        // 异或
        System.out.println("12的二进制：" + Integer.toBinaryString(12));
        System.out.println("2的二进制：" + Integer.toBinaryString(2));
        System.out.println("12和2异或运算后" + Integer.toBinaryString(12 ^ 2));
        System.out.println();

        // 移位()
        System.out.println("12的二进制：" + Integer.toBinaryString(12));
        // 左移 低位补0，
        System.out.println("12左移2位：" + Integer.toBinaryString(12 << 2) + ";十进制值：" + (12 << 2));
        // 有符号右移，若为负数高位补1，若为整数高位补0
        System.out.println("12右移2位：" + Integer.toBinaryString(12 >> 2) + ";十进制值：" + (12 >> 2));
        System.out.println("-12右移2位：" + Integer.toBinaryString(-12 >> 2) + ";十进制值：" + (-12 >> 2));
        // 无符号右移，高位补0
        System.out.println("12右移2位：" + Integer.toBinaryString(12 >>> 2) + ";十进制值：" + (12 >>> 2));

    }
}
