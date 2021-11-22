package leetcode704;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.binarySearch;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 二分查找
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int search = new Solution().search(nums, target);
        System.out.println(search);

    }


    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 升序集合-二分查找
     * @date 2021/11/4 17:28
     */
    public int search(int[] nums, int target) {


        return binSearch(nums, target, 0, nums.length - 1);


    }

    private int binSearch(int[] nums, int target, int left, int right) {

        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binSearch(nums, target, mid + 1, right);
        } else {
            return binSearch(nums, target, left, mid - 1);
        }

    }
}
