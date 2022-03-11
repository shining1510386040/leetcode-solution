package newcoder003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 滑动窗口内的最大值
 * @date 2022/3/1 19:01
 * @see
 */
public class MainTest {

    public static void main(String[] args) {
//
//        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
//        int size = 3;
//        //[4,4,6,6,6,5]
//
//        int[] nums = {9, 10, 9, -7, -3, 8, 2, -6};
//        int size = 5;
//        //[10,10,9,8]
//
        int[] nums = {1, 2, 3, 4};
        int size = 5;
        //[]

        Integer[] ret = getMaxNumInWid(nums, size);
        System.out.println(Arrays.toString(ret));
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 获取滑动窗口内的最大值
     * @date 2022/3/2 20:21
     */
    private static Integer[] getMaxNumInWid(int[] nums, int size) {
        List<Integer> ret = new ArrayList<>();
        if (size == 0 || size > nums.length) {
            return null;
        }
        // 滑动窗口内的队列
        int left = 0;
        int right = left + size - 1;

        LinkedList queue = new LinkedList();
        //初始化队列中元素
        for (; left <= right; left++) {
            // 入队
            queue.addFirst(nums[left]);
        }
        while (right < nums.length) {

            //1.获取滑动窗口内的最大值
            int max = 0;
            for (Object item : queue) {

                max = Integer.max(max, (int) item);

            }
            ret.add(max);
            // 滑动
            left++;
            right++;
            queue.removeLast();
            if (right < nums.length - 1) {
                // 出队
                queue.addFirst(nums[right]);
            }
        }
        Integer[] integers = ret.toArray(new Integer[ret.size()]);
        return integers;
    }


}
