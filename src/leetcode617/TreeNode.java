package leetcode617;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 树节点
 * @date 2021/11/12 15:07
 * @see
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
