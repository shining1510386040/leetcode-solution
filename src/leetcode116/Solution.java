package leetcode116;

import java.util.*;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 填充每个节点的右侧节点
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);

        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);

        Node root = new Node(1, node2, node3, null);
        Node connect = new Solution().connect(root);
    }

    //    方法一：层次遍历
//
//            思路与算法
//
//    题目本身希望我们将二叉树的每一层节点都连接起来形成一个链表。因此直观的做法我们可以对二叉树进行层次遍历，在层次遍历的过程中将我们将二叉树每一层的节点拿出来遍历并连接。
//
//    层次遍历基于广度优先搜索，它与广度优先搜索的不同之处在于，广度优先搜索每次只会取出一个节点来拓展，而层次遍历会每次将队列中的所有元素都拿出来拓展，这样能保证每次从队列中拿出来遍历的元素都是属于同一层的，因此我们可以在遍历的过程中修改每个节点的 next\text{next}next 指针，同时拓展下一层的新队列。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public Node connect(Node root) {

        // 层序遍历：+ 队列（存储每一层的节点）
        if (root == null) {
            return root;
        }

        // 初始化队列并将根节点入队
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 当前层 的节点个数
            int size = queue.size();

            // 当前层出队并连接
            for (int i = 0; i < size; i++) {
                // 出队
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 添加下一层
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
