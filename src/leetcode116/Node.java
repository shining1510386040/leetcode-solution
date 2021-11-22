package leetcode116;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 完美二叉树
 * @date 2021/11/12 16:27
 * @see
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};