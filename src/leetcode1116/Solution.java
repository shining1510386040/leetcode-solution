package leetcode1116;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 打印0与奇偶数
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int n = 2;
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
//        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(5);
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(n);

        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero((e) -> {
                    System.out.print(e);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even((e) -> {
                    System.out.print(e);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd((e) -> {
                    System.out.print(e);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();


    }


}
