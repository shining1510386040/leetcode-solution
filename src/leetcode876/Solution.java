package leetcode876;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 链表的中间节点
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {


    //    给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
//    如果有两个中间结点，则返回第二个中间结点。
    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode2);

        System.out.println("原始链表：" + head);
        ListNode ret = new Solution().middleNode(head);
        ListNode ret1 = new Solution().middleNode1(head);
        ListNode ret2 = new Solution().middleNode2(head);
        System.out.println("中间节点：" + ret);
        System.out.println("中间节点1：" + ret1);
        System.out.println("中间节点2：" + ret2);

    }


    /**
     * 单指针法：
     */
    public ListNode middleNode(ListNode head) {

        // 节点个数
        int num = 0;
        ListNode next = head;
        while (next != null) {
            num++;
            next = next.next;
        }
        ListNode newHead = head;
        for (int i = 0; i < num / 2; i++) {
            newHead = newHead.next;
        }

        return newHead;
    }

    /**
     * 快慢指针法：
     * 用两个指针 slow 与 fast 一起遍历链表。
     * slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间
     */
    public ListNode middleNode1(ListNode head) {

        // 快指针，一次走两步
        ListNode fast = head;
        // 慢指针,一次走一步
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 借助数组：数组可确定长度和 index索引
     */
    public ListNode middleNode2(ListNode head) {

        ListNode[] arr = new ListNode[100];
        ListNode next = head;
        int cur = 0;
        while (next != null) {
            arr[cur++] = next;
            next = next.next;
        }

        return arr[cur / 2];
    }


}
