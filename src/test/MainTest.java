package test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 验证用户名合法性，
 * 正则表达式
 * @date 2021/11/18 19:46
 * @see
 */
public class MainTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer loop = scanner.nextInt();
        LinkedList<String> queue = new LinkedList();
        for (int i = 0; i < loop + 1; i++) {
            queue.offer(scanner.nextLine());
        }

        while (!queue.isEmpty()) {
            String pop = queue.pop();
            if (!"".equalsIgnoreCase(pop)) {
                System.out.println(checkUsername(pop));
            }
        }
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 校验用户名
     * @date 2021/11/18 19:54
     */
    private static String checkUsername(String pop) {
//        1.用户名的首字符必须是大写或者小写字母。
//        2.用户名只能包含大小写字母，数字。
//        3.用户名需要包含至少一个字母和一个数字。
//        如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/BaR9fy
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

        String seq = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "0123456789";

        //
        int numCount = 0;
        int charCount = 0;

        char first = pop.charAt(0);
        if (!seq.contains(first + "")) {
            return "Wrong";
        }
        for (int i = 0; i < pop.length(); i++) {
            String cur = pop.charAt(i) + "";
            if (num.contains(cur)) {
                numCount++;
            }
            if (seq.contains(cur)) {
                charCount++;
            }
            if (!num.contains(cur) && !seq.contains(cur)) {
                return "Wrong";
            }
        }

        if (numCount == 0 || charCount == 0) {
            return "Wrong";
        }
        return "Accept";

    }
}
