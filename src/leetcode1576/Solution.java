package leetcode1576;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 替换？为字符
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        String input = "??yw?ipkj?";
        String ret = new Solution().modifyString(input);
        System.out.println(ret);

    }


    public String modifyString1(String input) {

        // 可替换的值
        String str = "abcdefghijklmnopqrstuvwxyz";
        // 替换次数
        for (int i = 0; i < input.length(); i++) {
            if ('?' != input.charAt(i)) {
                str = str.replace(input.charAt(i) + "", "");
            }
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if ('?' == input.charAt(i)) {
                input = input.replaceFirst("\\?", arr[i] + "");
            }
        }

        return input;
    }

    public String modifyString2(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                // 使用abc 中的一个替换
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

    public String modifyString(String input) {

        char[] arr = {'a', 'b', 'c'};
        for (int i = 0; i < input.length(); i++) {
            if ('?' == input.charAt(i)) {
                for (int j = 0; j < 3; j++) {
                    if (i > 0 && input.charAt(i - 1) == arr[j] || i < input.length() - 1 && input.charAt(i + 1) == arr[j]) {
                        continue;
                    }
                    input = input.replaceFirst("\\?", arr[j] + "");
                    break;
                }

            }
        }
        return input;
    }


}
