package leetcode557;

import java.util.Arrays;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 反转字符串中的单词 III
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {


    public static void main(String[] args) {


        String s = "Let's take LeetCode contest";
        System.out.println("字符串单词反转前：" + s);
        String ret = new Solution().reverseWords(s);
        System.out.println("字符串单词反转后：" + ret);

    }


    public String reverseWords(String s) {

        String[] split = s.split(" ");
        String ret = "";
        for (String item : split) {
            ret += reverse(item.toCharArray()) + " ";
        }
        return ret.substring(0,ret.lastIndexOf(" "));
    }

    private String reverse(char[] arr) {

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

}
