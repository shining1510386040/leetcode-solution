package leetcode695;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 岛屿的最大面积
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    private int[] dx = {1, 0};
    private int[] dy = {0, 1};

    public static void main(String[] args) {

        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}

        };

        int ret = new Solution().maxAreaOfIsland(grid);
        System.out.println(ret);

    }

    //    我们想知道网格中每个连通形状的面积，然后取最大值。
//
//    如果我们在一个土地上，以 444 个方向探索与之相连的每一个土地（以及与这些土地相连的土地），那么探索过的土地总数将是该连通形状的面积。
//
//    为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 000。这样我们就不会多次访问同一土地。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxAreaOfIsland(int[][] grid) {

        int ret = 0;
        // 行数
        int m = grid.length;
        // 列数
        int n = grid[0].length;
        for (int i = 0; i != m; i++) {
            for (int j = 0; j != n; j++) {
                ret = Math.max(ret, dfs(grid, i, j));
            }
        }
        return ret;
    }

    /**
     * 深度优先搜索：上下左右 四个方向搜索： 搜索过得设置为0，避免重复；
     */
    private int dfs(int[][] grid, int curi, int curj) {
        if (curi < 0 || curj < 0 || curi >= grid.length || curj >= grid[0].length || grid[curi][curj] == 0) {
            // 当前位置为0 或超出边界
            return 0;
        }
        int ret = 1;
        // 当前位置设置为0
        grid[curi][curj] = 0;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        for (int i = 0; i < 4; i++) {
            int mx = curi + dx[i];
            int my = curj + dy[i];
            ret += dfs(grid, mx, my);

        }
        return ret;
    }
}
