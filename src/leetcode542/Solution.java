package leetcode542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 01 矩阵
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
//    两个相邻元素间的距离为 1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/01-matrix
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));

        System.out.println("=====================>>>>>");
        int[][] ints = new Solution().updateMatrix(matrix);
        System.out.println(Arrays.toString(ints[0]));
        System.out.println(Arrays.toString(ints[1]));
        System.out.println(Arrays.toString(ints[2]));

    }

    /**
     * 广度优先搜索的偏移：
     */
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 解法：https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
     */
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;

    }
}
