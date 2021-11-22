package leetcode002;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 两数相加
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        // l1 = [2,4,3], l2 = [5,6,4]
        ListNode tail1 = new ListNode(3);
        ListNode mid1 = new ListNode(4, tail1);
        ListNode l1 = new ListNode(2, mid1);

        ListNode tail2 = new ListNode(4);
        ListNode mid2 = new ListNode(6, tail2);
        ListNode l2 = new ListNode(5, mid2);

//        System.out.println(l1);

        ListNode ret = new Solution().addTwoNumbers(l1, l2);
        System.out.println(ret);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num1 = this.getNum(l1);
        int num2 = this.getNum(l2);
        int sum = num1 + num2;

        System.out.println(sum);
        ListNode ret = this.generateListNode(sum);

        return ret;
    }

    private ListNode generateListNode(int sum) {
        // 807
        char[] chars = (sum + "").toCharArray();
        ListNode head = new ListNode();
        int i = 0;
        ListNode mid = null;
        while (i < chars.length - 1) {
            Integer cur = Integer.valueOf(chars[i]);
            mid = new ListNode(cur);
            mid.setNext(new ListNode());
            i++;
        }
        head.setNext(mid);
        return head;
    }

    private int getNum(ListNode data) {
        // 2 4 3
        ListNode next = data;
        Stack<Integer> stack = new Stack<>();
        while (next != null) {
            int val = next.getVal();
            stack.push(val);
            next = next.getNext();
        }
        String ret = "";
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            ret += "" + pop;
        }
        return Integer.valueOf(ret);
    }


    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 正确解法
     * @date 2021/11/1 15:03
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }

}
