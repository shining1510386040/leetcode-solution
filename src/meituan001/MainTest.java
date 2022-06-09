package meituan001;

import java.util.*;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 链表逆序放入一个数组中
 * @date 2022/6/9 9:55
 * @see
 */
public class MainTest {

    public static void main(String[] args) {
        // 1->2->3->null
        ListNode tail = new ListNode(3, null);
        ListNode node1 = new ListNode(2, tail);
        ListNode head = new ListNode(1, node1);

        // 1.正常思路：二次循环，一次循环正序放入数组，二次循环数组逆序
//        int[] ret = solve1(head);
        // 2.利用栈的数据结构：Stack
        Object[] ret = solve2(head);
        // 3.使用递归（递归的本质是 系统栈）：
//        Object[] ret = solve3(head);
        // 3 2 1
        System.out.println(Arrays.toString(ret));
    }

    private static LinkedList data = new LinkedList();

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 递归方式实现
     * @date 2022/6/9 10:04
     */
    private static Object[] solve3(ListNode head) {
        if (head != null) {
            solve3(head.getNext());
            data.add(head.getData());
        }
        return data.toArray();
    }

    private static Object[] solve2(ListNode head) {

        LinkedList<Integer> result = new LinkedList<>();
        while (head != null) {
            // 循环链表，依次入栈
            result.push(head.getData());
            head = head.getNext();
        }
        // 循环栈；出栈
        while (!result.isEmpty()) {
            Integer pop = result.pop();
            data.add(pop);
        }
        return data.toArray();
    }

    private static int[] solve1(ListNode head) {
        // 链表
        LinkedList<Integer> result = new LinkedList<>();
        while (head != null) {
            result.add(head.getData());
            head = head.getNext();
        }
        int[] ret = new int[result.size()];
        for (int i = result.size() - 1, j = 0; i >= 0; i--) {
            ret[j] = result.get(i);
            j++;
        }
        return ret;
    }
}
