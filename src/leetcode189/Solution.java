package leetcode189;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 旋转数组
 * @see
 */
public class Solution {


    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("原数组：" + Arrays.toString(nums));
        new Solution().rotate(nums, k);
//        new Solution().rotate1(nums, k);
//        new Solution().rotate2(nums, k);
        System.out.println("旋转后数组：" + Arrays.toString(nums));

    }

    public void rotate(int[] nums, int k) {

        // k > 0
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cur = (i + k) % nums.length;
            ret[cur] = nums[i];
        }
        // 数组复制
        System.arraycopy(ret, 0, nums, 0, nums.length);
        // 数组复制不能单纯赋值引用
//        nums = ret;
        System.out.println(Arrays.toString(nums));

    }

    // 内存溢出
    public void rotate1(int[] nums, int k) {

        // k >0
        int loop = k % nums.length;
        for (int i = 0; i < loop; i++) {
            // 数组右移一位
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }

    }

    public void rotate2(int[] nums, int k) {

        // 翻转整体
        reverse(nums, 0, nums.length - 1);
        // 翻转前k部分
        int loop = k % nums.length;
        reverse(nums, 0, loop - 1);
        // 翻转后面部分
        reverse(nums, loop, nums.length - 1);


    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 数组翻转
     * @date 2021/11/8 11:59
     */
    private void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
