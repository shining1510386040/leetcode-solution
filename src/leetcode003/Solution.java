package leetcode003;

import java.util.*;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 求无重复字符的最长子串的长度
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    /**
     * 方法一：滑动窗口
     * <p>
     * 思路和算法
     * <p>
     * 我们先用一个例子考虑如何在较优的时间复杂度内通过本题。
     * <p>
     * 我们不妨以示例一中的字符串 abcabcbb\texttt{abcabcbb}abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
     * <p>
     * 以 (a)bcabcbb\texttt{(a)bcabcbb}(a)bcabcbb 开始的最长字符串为 (abc)abcbb\texttt{(abc)abcbb}(abc)abcbb；
     * 以 a(b)cabcbb\texttt{a(b)cabcbb}a(b)cabcbb 开始的最长字符串为 a(bca)bcbb\texttt{a(bca)bcbb}a(bca)bcbb；
     * 以 ab(c)abcbb\texttt{ab(c)abcbb}ab(c)abcbb 开始的最长字符串为 ab(cab)cbb\texttt{ab(cab)cbb}ab(cab)cbb；
     * 以 abc(a)bcbb\texttt{abc(a)bcbb}abc(a)bcbb 开始的最长字符串为 abc(abc)bb\texttt{abc(abc)bb}abc(abc)bb；
     * 以 abca(b)cbb\texttt{abca(b)cbb}abca(b)cbb 开始的最长字符串为 abca(bc)bb\texttt{abca(bc)bb}abca(bc)bb；
     * 以 abcab(c)bb\texttt{abcab(c)bb}abcab(c)bb 开始的最长字符串为 abcab(cb)b\texttt{abcab(cb)b}abcab(cb)b；
     * 以 abcabc(b)b\texttt{abcabc(b)b}abcabc(b)b 开始的最长字符串为 abcabc(b)b\texttt{abcabc(b)b}abcabc(b)b；
     * 以 abcabcb(b)\texttt{abcabcb(b)}abcabcb(b) 开始的最长字符串为 abcabcb(b)\texttt{abcabcb(b)}abcabcb(b)。
     * <p>
     * 发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 kkk 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为 rkr_krk​。那么当我们选择第 k+1k+1k+1 个字符作为起始位置时，首先从 k+1k+1k+1 到 rkr_krk​ 的字符显然是不重复的，并且由于少了原本的第 kkk 个字符，我们可以尝试继续增大 rkr_krk​，直到右侧出现了重复字符为止。
     * <p>
     * 这样一来，我们就可以使用「滑动窗口」来解决这个问题了：
     * <p>
     * 我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 rkr_krk​；
     * <p>
     * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
     * <p>
     * 在枚举结束后，我们找到的最长的子串的长度即为答案。
     * <p>
     * 判断重复字符
     * <p>
     * 在上面的流程中，我们还需要使用一种数据结构来判断 是否有重复的字符，常用的数据结构为哈希集合（即 C++ 中的 std::unordered_set，Java 中的 HashSet，Python 中的 set, JavaScript 中的 Set）。在左指针向右移动的时候，我们从哈希集合中移除一个字符，在右指针向右移动的时候，我们往哈希集合中添加一个字符。
     * <p>
     * 至此，我们就完美解决了本题
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

        String s = "pwwkew";

        int ret = new Solution().lengthOfLongestSubstring(s);

        System.out.println(ret);
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 滑动窗口
     * @date 2021/11/11 18:39
     */
    public int lengthOfLongestSubstring(String s) {

        // left 指向最长子串左侧，right指向右侧，左侧 每次移动一个，右侧不断右滑
        // Set 判断是否重复
        int right = -1;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ret = 0;
        for (int left = 0; left < n; left++) {

            if (left != 0){
                // 左指针 每向右移动一个 set中删除一个元素
                set.remove(s.charAt(left-1));
            }

            // 右指针不断右滑
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }

            ret = Math.max(ret, right - left + 1);

        }

        return ret;

    }
}
