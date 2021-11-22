package leetcode35;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 5;
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
            return left;
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
