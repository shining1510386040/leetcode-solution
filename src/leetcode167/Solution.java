package leetcode167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 两数之和 II - 输入有序数组
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    /**
     * 输入的数组是有序的：
     * 1. 代表可以利用二分查找，减少查找次数
     */
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
//        int[] ret = solution.twoSum(nums, target);
        int[] ret = solution.twoSum1(nums, target);
//        int[] ret = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ret));

    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 利用二分查找
     * @date 2021/11/8 15:03
     */
    private int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            //
            int low = i + 1;
            int hight = nums.length - 1;

            while (low <= hight) {
                int mid = low + (hight - low) / 2;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (nums[mid] < target - nums[i]) {
                    //
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }

        }

        return new int[0];
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 使用双指针
     * @date 2021/11/8 15:03
     */
    private int[] twoSum2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 使用map结构
     * @date 2021/11/8 15:02
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 赋值
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] ret = new int[2];
                ret[0] = i + 1;
                ret[1] = map.get(nums[i]) + 1;
                return ret;
            }
        }
        return null;

    }


}
