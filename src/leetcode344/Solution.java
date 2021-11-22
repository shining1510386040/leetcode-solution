package leetcode344;

import java.util.Arrays;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 反转字符串
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-string
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {


        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("字符串反转前：" + Arrays.toString(s));
        new Solution().reverseString(s);
        System.out.println("字符串反转后：" + Arrays.toString(s));

    }


    /**
     * 双指针解法：
     */
    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length-1;
        while (left < right) {
            //交换
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

    }
}
