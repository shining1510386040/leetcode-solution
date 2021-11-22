package leetcode283;

import java.util.Arrays;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 移动0
 * @see
 */
public class Solution {


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
//        new Solution().moveZeroes(nums);
        new Solution().moveZeroes1(nums);
        System.out.println("移动0后：" + Arrays.toString(nums));

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 官方思路
     * @date 2021/11/8 14:36
     */
    private void moveZeroes1(int[] nums) {

        // 左指针 指向非0序列尾部
        int left = 0;
        // 右指针 执行非0数字
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                // 交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
            right++;
        }


    }

    public void moveZeroes(int[] nums) {

        // 非0
        int start = 0;
        // 0
        int end = nums.length - 1;
        while (start < end) {
            for (int num : nums) {
                if (num != 0) {
                    nums[start] = num;
                    start++;
                } else {
                    end--;
                }
            }
        }
        // 填充0
        for (int i = end + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
