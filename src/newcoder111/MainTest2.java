package newcoder111;

import java.util.Scanner;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2022/6/1 22:13
 * @see
 */
public class MainTest2 {

    public static void main(String[] args) {
        String input = "zz4a";

        String out = solve(input);
        System.out.println(out);

//        Scanner scanner = new Scanner();
//        while (scanner.hasNextLine())
//        String s = scanner.nextLine();

    }

    private static String solve(String input) {
        // 1.校验字符串合法性 只能为小写字母和数字

        // 2.还原
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            try {
                // 最后一位是数字，错误
                Integer last = Integer.valueOf(chars[chars.length - 1] + "");
                return "!error";
            } catch (Exception e) {

            }
            char c = chars[i];
            try {
                // 数字
                Integer integer = Integer.valueOf(c + "");

                try {

                    Integer next = Integer.valueOf(chars[i + 1] + "");
                    // 如果下一位也是数字.不会超过100个字符。 99ab
                    if (integer == 0) {
                        return "!error";
                    }
                    int j = 0;
                    while (j < integer * 10 + next) {
                        j++;
                        sb.append(chars[i + 2]);
                    }
                    i = i + 2;
                } catch (Exception e) {
                    if (integer < 3) {
                        return "!error";
                    }
                    int j = 0;
                    while (j < integer) {
                        j++;
                        sb.append(chars[i + 1]);
                    }
                    i = i + 1;
                }
            } catch (Exception e) {
                // 字母
                if (c < 'a' || c > 'z') {
                    return "!error";
                }
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
