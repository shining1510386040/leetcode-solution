package leetcode217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 判断数组中是否存在重复元素
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定一个整数数组，判断是否存在重复元素。
//
//    如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(nums));


    }

    public boolean containsDuplicate(int[] nums) {

        Set set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }
}
