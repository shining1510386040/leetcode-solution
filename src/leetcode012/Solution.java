package leetcode012;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 整数转化为罗马数字
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcod-75rs/
    public static void main(String[] args) {

        int num = 234;
        String ret = convert2RomaNum(num);
        System.out.println(ret);

    }

    private static String[] thousands = {"", "M", "MM", "MMM"};
    private static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 硬编码法
     * @date 2022/4/12 21:06
     */
    private static String convert2RomaNum(int num) {

        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();

    }


    private static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 模拟
     * @date 2022/4/12 21:07
     */
    private static String convert2RomaNum2(int num) {

        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }


}
