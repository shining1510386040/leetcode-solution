package leetcode002;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 链表节点
 * @date 2021/11/1 11:44
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

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode next = this;
        String ret = "[";
        while (next != null) {
            ret += "," + next.val;
            next = next.next;
        }
        return ret + "]";
    }
}