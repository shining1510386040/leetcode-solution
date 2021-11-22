package leetcode19;


import java.util.LinkedList;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 删除链表的倒数第 N 个结点
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {


    //    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//    进阶：你能尝试使用一趟扫描实现吗？
    public static void main(String[] args) {

        /**
         * 注：对链表操作时常用 dumaryHead 哑节点，避免对头节点的特殊操作；
         *
         */

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode2);

        System.out.println("原始链表：" + head);
        int n = 2;
//        ListNode ret = new Solution().removeNthFromEnd(head, 2);
//        System.out.println("删除后链表：" + ret);

//        ListNode ret2 = new Solution().removeNthFromEnd2(head, 2);
//        System.out.println("删除后链表2：" + ret2);

        ListNode ret3 = new Solution().removeNthFromEnd3(head, 2);
        System.out.println("删除后链表3：" + ret3);


    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 利用栈的特性，找到前驱节点
     * @date 2021/11/8 17:05
     */
    private ListNode removeNthFromEnd3(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        // LinkedList:双向链表，栈
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
//        stack.addFirst();
//        stack.addLast();
//        stack.removeFirst();
//        stack.removeLast();
//
//        stack.push();
//        stack.pop();
//        stack.offer();
//        stack.remove()
//
//
//        stack.peek();
//        stack.poll();
//
        // 节点入栈
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        // 找到前驱节点，n个节点出栈
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode pre = stack.peek();
        pre.next = pre.next.next;

        return dummy.next;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 使用双指针：
     * fast 比 slow 快n 步；
     * @date 2021/11/8 17:16
     */
    private ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;

        // fast 指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow 为前驱节点
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 常规思路：找到删除节点的前驱节点，删除
     * @date 2021/11/8 17:00
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 虚拟头节点，哑节点
        ListNode dummy = new ListNode(0, head);
        // 链表的节点个数
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        // 找到前驱节点
        ListNode pre = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            pre = pre.next;
        }
        // 删除
        pre.next = pre.next.next;

        return dummy.next;

    }


}
