package leetcode001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 两数之和
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] ret = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ret));
        System.out.println("================>>>分割线<<<<===========");
        int[] ret2 = solution.twoSumWithMap(nums, target);
        System.out.println(Arrays.toString(ret2));

    }

    private int[] twoSumWithMap(int[] nums, int target) {

        // 1.构造map结构存储 <another,index>
        Map<Integer, Integer> map = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        // 2.查找
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ret[1] = i;
                ret[1] = map.get(nums[i]);
                return ret;
            }
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {

        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (another == nums[j]) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }

        return ret;
    }
}
