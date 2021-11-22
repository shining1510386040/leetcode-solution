package leetcode136;

import java.util.*;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 只出现一次的数字
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    //    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//    说明：
//
//    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//
    public static void main(String[] args) {

        int[] nums = {2, 2, 1};
        int ret = new Solution().singleNumber(nums);
        System.out.println(ret);

        int ret1 = new Solution().singleNumber1(nums);
        System.out.println(ret1);

    }

    /**
     * O(1) 复杂度，不使用额外空间：
     * 异或运算 ^
     * <p>
     * 答案是使用位运算。对于这道题，可使用异或运算 ⊕\oplus⊕。异或运算有以下三个性质。
     * <p>
     * 任何数和 000 做异或运算，结果仍然是原来的数，即 a⊕0=aa \oplus 0=aa⊕0=a。
     * 任何数和其自身做异或运算，结果是 000，即 a⊕a=0a \oplus a=0a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=ba \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * <p>
     * 假设数组中有 2m+12m+12m+1 个数，其中有 mmm 个数各出现两次，一个数出现一次。令 a1a_{1}a1​、a2a_{2}a2​、…\ldots…、ama_{m}am​ 为出现两次的 mmm 个数，am+1a_{m+1}am+1​ 为出现一次的数。根据性质 3，数组中的全部元素的异或运算结果总是可以写成如下形式：
     * <p>
     * (a1⊕a1)⊕(a2⊕a2)⊕⋯⊕(am⊕am)⊕am+1(a_{1} \oplus a_{1}) \oplus (a_{2} \oplus a_{2}) \oplus \cdots \oplus (a_{m} \oplus a_{m}) \oplus a_{m+1} (a1​⊕a1​)⊕(a2​⊕a2​)⊕⋯⊕(am​⊕am​)⊕am+1​
     * <p>
     * 根据性质 2 和性质 1，上式可化简和计算得到如下结果：
     * <p>
     * 0⊕0⊕⋯⊕0⊕am+1=am+10 \oplus 0 \oplus \cdots \oplus 0 \oplus a_{m+1}=a_{m+1} 0⊕0⊕⋯⊕0⊕am+1​=am+1​
     */
    public int singleNumber(int[] nums) {

        // 数组中所有元素做异或 即为 只出现一次的那个数字

        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 使用额外空间 set集合
     * @date 2021/11/17 19:17
     */
    public int singleNumber1(int[] nums) {

        // 数组中所有元素做异或 即为 只出现一次的那个数字

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // set 集合：元素不重复，
            // set中存在此元素则删除，不存在则添加
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Integer next = set.iterator().next();
        return next;
    }


}
