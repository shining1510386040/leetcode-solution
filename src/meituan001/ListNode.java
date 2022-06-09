package meituan001;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 链表节点
 * @date 2022/6/9 10:00
 * @see
 */
public class ListNode {

    private Integer data;

    private ListNode next;

    public ListNode(Integer data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
