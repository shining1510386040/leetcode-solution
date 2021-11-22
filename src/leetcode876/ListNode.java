package leetcode876;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 链表
 * @date 2021/11/8 15:56
 * @see
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode next = this;
        while (next != null) {
            sb.append("," + next.val);
            next = next.next;
        }
        return sb.toString();
    }
}
