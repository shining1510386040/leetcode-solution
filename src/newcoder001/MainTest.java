package newcoder001;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description TODO
 * @date 2022/3/1 19:01
 * @see
 */
public class MainTest {

    public static void main(String[] args) {
//        int[] cars = {1, 0, 1};   // 2
        int[] cars = {1, 1, 0, 0, 1, 1, 1, 0, 1};   // 3
        int num = getmaxcar(cars);
        System.out.println("最少停车数量为：" + num);
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 双指针法
     * @date 2022/3/1 19:04
     */
    private static int getmaxcar(int[] cars) {

        int ret = 0;
        int left = 0, right = 1;
        while (left < cars.length && left <= right) {
            if (cars[left] == 0) {
                left++;
                right++;
            } else {
                while (right < cars.length && (right - left < 4) && cars[right] == 1) {
                    right++;
                }
                left = right;
                right = left + 1;
                ret++;
            }
        }
        return ret;
    }
}
