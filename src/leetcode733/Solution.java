package leetcode733;

import java.util.*;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 图像渲染
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    // 位置i 的偏移
    private int[] dx = {1, 0, 0, -1};
    // 位置j 的偏移
    private int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        System.out.println("初始图像");
        System.out.println(Arrays.toString(image[0]));
        System.out.println(Arrays.toString(image[1]));
        System.out.println(Arrays.toString(image[2]));

//        int[][] ret = new Solution().floodFill(image, sr, sc, newColor);
        int[][] ret = new Solution().floodFill3(image, sr, sc, newColor);

        System.out.println(Arrays.toString(ret[0]));
        System.out.println(Arrays.toString(ret[1]));
        System.out.println(Arrays.toString(ret[2]));

    }

//    我们从给定的起点开始，进行广度优先搜索。每次搜索到一个方格时，如果其与初始位置的方格颜色相同，就将该方格加入队列，并将该方格的颜色更新，以防止重复入队。
//
//    注意：因为初始位置的颜色会被修改，所以我们需要保存初始位置的颜色，以便于之后的更新操作。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/flood-fill/solution/tu-xiang-xuan-ran-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * 广度优先搜索+队列
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // 列数
        int colLength = image[0].length;
        // 行数
        int rowLength = image.length;
        // 原始颜色
        int oldColor = image[sr][sc];

        image[sr][sc] = newColor;
        if (oldColor == newColor) {
            return image;
        }
        // 要渲染的位置入队列，防止重复渲染
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            // 队列不为空，一直渲染
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                // 偏移
                int mx = x + dx[i];
                int my = y + dy[i];
                // 在图像区域，并且和原来颜色相等
                if (mx >= 0 && mx < colLength && my >= 0 && my < rowLength
                        && oldColor == image[mx][my]) {
                    //入队
                    queue.offer(new int[]{mx, my});
                    // 上色
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

    /**
     * 深度优先搜索；
     */
    public int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {

        // 当前颜色
        int curColor = image[sr][sc];
        if (curColor != newColor) {
            // 深度搜索 各个位置 并赋值
            dfs(image, sr, sc, curColor, newColor);
        }

        return image;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 深度优先搜索（递归）
     * @date 2021/11/12 13:46
     */
    private void dfs(int[][] image, int x, int y, int curColor, int newColor) {

        if (curColor == image[x][y]) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < image.length
                        && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, curColor, newColor);
                }
            }
        }


    }

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {

        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;

    }


}
