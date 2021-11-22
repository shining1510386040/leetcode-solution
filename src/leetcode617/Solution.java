package leetcode617;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 合并二叉树
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
//    你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/merge-two-binary-trees
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, null);
        TreeNode treeNode2 = new TreeNode(3, null, null);
        TreeNode root1 = new TreeNode(1, treeNode3, treeNode2);

        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node1 = new TreeNode(1, null, node4);
        TreeNode node3 = new TreeNode(3, null, node7);
        TreeNode root2 = new TreeNode(2, node1, node3);

        TreeNode treeNode = new Solution().mergeTrees(root1, root2);
        System.out.println(treeNode);

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 深度搜索两个树，（根左右）
     * @date 2021/11/12 16:11
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode ret = null;
        // 一个树为null，返回另一个子树即可
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 左右子树均不为null
        ret = new TreeNode(root1.val + root2.val);
        ret.left = mergeTrees(root1.left, root2.left);
        ret.right = mergeTrees(root1.right, root2.right);
        return ret;
    }
}
