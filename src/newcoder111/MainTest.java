package newcoder111;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2022/6/1 21:24
 * @see
 */
public class MainTest {

    public static void main(String[] args) {

        // 0 - 8888 88888
        int input = 100;
//        int out = solve(input);
        int out = solve2(input);
        System.out.println(out);
    }

    private static int solve2(int input) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < 888888888; i++) {
           // todo .... 判断 4 存入map
            if ((i + "").contains("4")) {
                
            }
        }
        return 0;
    }

    private static int solve(int input) {

        int sub = 0;
        int index = input;
        while (input > 0) {
            if (input % 10 == 5 && !(input + "").contains("4")) {
                sub += 1;
            } else if (input % 100 == 50) {
                sub += 10;
            } else if (input % 1000 == 500) {
                sub += 100;
            } else if (input % 10000 == 5000) {
                sub += 1000;
            } else if (input % 100000 == 50000) {
                sub += 10000;
            } else if (input % 1000000 == 500000) {
                sub += 100000;
            } else if (input % 10000000 == 5000000) {
                sub += 1000000;
            } else if (input % 100000000 == 50000000) {
                sub += 10000000;
            }
            input = input - 1;
        }

        return index - sub;
    }
}
