package newcoder002;

import java.util.Arrays;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2022/3/1 19:01
 * @see
 */
public class MainTest {

    public static void main(String[] args) {
//        int[] cards = {22, 221};   // 22221
        int[] cards = {4589, 101, 41425, 9999};   // 9999458941425101
        String num = getMaxNum(cards);
        System.out.println("组成的最大数为：" + num);
    }

    private static String getMaxNum(int[] cards) {
        // 选择排序
        int temp;
        for (int i = 0; i < cards.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < cards.length; j++) {
                if (!judgeBig(cards[index], cards[j])) {
                    index = j;
                }
                if (index != i) {
                    // 找到比index位置更大的元素，交换
                    temp = cards[i];
                    cards[i] = cards[index];
                    cards[j] = temp;
                }
            }
        }

        System.out.println(Arrays.asList(cards));
        String ret = "";
        for (int i = 0; i < cards.length; i++) {
            ret += cards[i] + "";
        }

        return ret;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 判断左侧是否比右侧大
     * @date 2022/3/1 20:08
     */
    private static boolean judgeBig(int left, int right) {

        String leftS = left + "";
        String rightS = right + "";
        // 比较轮次
        int turns = Integer.min(leftS.length(), rightS.length());
        for (int i = 0; i < turns; ) {
            if (leftS.charAt(i) > rightS.charAt(i)) {
                return true;
            } else if (leftS.charAt(i) == rightS.charAt(i)) {
                i++;
            } else {
                return false;
            }
        }
        return false;
    }


}
