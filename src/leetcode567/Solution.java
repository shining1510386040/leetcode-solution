package leetcode567;

import java.util.Arrays;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 字符串的排列
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean ret = new Solution().checkInclusion(s1, s2);
        System.out.println(ret);

    }

    //    方法一：滑动窗口
//
//    由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，
//    一个字符串才是另一个字符串的排列。
//
//    根据这一性质，记 s1s_1s1​ 的长度为 nnn，我们可以遍历 s2s_2s2​ 中的每个长度为 nnn 的子串，判断子串和 s1s_1s1​ 中每个字符的个数是否相等，若相等则说明该子串是 s1s_1s1​ 的一个排列。
//
//    使用两个数组 cnt1\textit{cnt}_1cnt1​ 和 cnt2\textit{cnt}_2cnt2​，cnt1\textit{cnt}_1cnt1​ 统计 s1s_1s1​ 中各个字符的个数，cnt2\textit{cnt}_2cnt2​ 统计当前遍历的子串中各个字符的个数。
//
//    由于需要遍历的子串长度均为 nnn，我们可以使用一个固定长度为 nnn 的滑动窗口来维护 cnt2\textit{cnt}_2cnt2​：滑动窗口每向右滑动一次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符。然后，判断 cnt1\textit{cnt}_1cnt1​ 是否与 cnt2\textit{cnt}_2cnt2​ 相等，若相等则意味着 s1s_1s1​ 的排列之一是 s2s_2s2​ 的子串。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        // s1 中26个字母出现的次数
        int[] ctn1 = new int[26];
        // s2 的长度为n的子串的 26个字母出现次数
        int[] ctn2 = new int[26];
        // 初始化值
        for (int i = 0; i < n; i++) {
            // s1 初始化
            ctn1[s1.charAt(i) - 'a']++;
            ctn2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(ctn1, ctn2)) {
            return true;
        }

        // s2 固定长度为n的窗口右滑
        for (int i = n; i < m; i++) {
            // 左侧滑出字符个数减1
            ctn2[s2.charAt(i - n) - 'a']--;
            // 右侧滑入字符个数加1
            ctn2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(ctn1, ctn2)) {
                return true;
            }
        }

        return false;
    }
}
