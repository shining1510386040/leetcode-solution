package leetcode977;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description
 * @see
 */
public class Solution {

    //    方法三：双指针
//
//            思路与算法
//
//    同样地，我们可以使用两个指针分别指向位置 000 和 n−1n-1n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。这种方法无需处理某一指针移动至边界的情况，读者可以仔细思考其精髓所在。
//
//    代码
//
//    class Solution {
//        public int[] sortedSquares(int[] nums) {
//            int n = nums.length;
//            int[] ans = new int[n];
//            for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
//                if (nums[i] * nums[i] > nums[j] * nums[j]) {
//                    ans[pos] = nums[i] * nums[i];
//                    ++i;
//                } else {
//                    ans[pos] = nums[j] * nums[j];
//                    --j;
//                }
//                --pos;
//            }
//            return ans;
//        }
//    }
//
//    复杂度分析
//
//    时间复杂度：O(n)O(n)O(n)，其中 nnn 是数组 nums\textit{nums}nums 的长度。
//
//    空间复杂度：O(1)O(1)O(1)。除了存储答案的数组以外，我们只需要维护常量空间。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};
        int[] search = new Solution().sortedSquares1(nums);
        System.out.println(Arrays.toString(search));

    }

    public int[] sortedSquares(int[] nums) {

        int[] ret = new int[nums.length];
        // 双指针：
        for (int i = 0, j = nums.length - 1, pos = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                // 将大的放到尾部
                ret[pos] = nums[i] * nums[i];
                i++;
            } else {
                ret[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }


        return ret;

    }

    public int[] sortedSquares1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // 排序
        Arrays.sort(nums);
        return nums;
    }

}
