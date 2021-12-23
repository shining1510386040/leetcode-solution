package leetcode48;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 旋转图像
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//    你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/rotate-image
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("==========>>原矩阵=====");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
//        new Solution().rotate(matrix);
//        new Solution().rotate1(matrix);
        new Solution().rotate2(matrix);
        System.out.println("==========>>原地旋转90度后矩阵=====");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 思路：翻转代替旋转
     * 先水平翻转 然后 主对角线翻转
     * @date 2021/11/25 12:02
     */
    public void rotate(int[][] matrix) {

        // n * n
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 解法2：使用额外临时二维数组（非原地旋转）
     * 第i行 变成 第 n-i-1 列
     * @date 2021/11/25 13:40
     */
    public void rotate1(int[][] matrix) {


        int n = matrix.length;
        // 使用额外临时数组 存储旋转90度后数组
        int[][] arrNew = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrNew[j][n - i - 1] = matrix[i][j];
            }
        }
        // 赋值给原来数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arrNew[i][j];
            }
        }

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 旋转4次会回到原位；
     * 临时变量存储（i,j）位置的值
     * @date 2021/11/25 13:45
     */
    public void rotate2(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
