package leetcode1116;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 打印0、奇数、偶数；三个线程
 * 解法1：
 * @date 2021/12/24 14:48
 * @see
 */
public class ZeroEvenOdd1 {

    private int n;

    /**
     * 一个许可的latch，控制打印0
     */
    private CountDownLatch zeroLatch = new CountDownLatch(0);

    /**
     * 控制打印偶数
     */
    private CountDownLatch evenLatch = new CountDownLatch(1);

    /**
     * 控制打印奇数
     */
    private CountDownLatch oddLatch = new CountDownLatch(1);


    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        // 打印0
        for (int i = 1; i <= n; i++) {
            zeroLatch.await();
            printNumber.accept(0);
            zeroLatch = new CountDownLatch(1);
            if (i % 2 == 0) {
                //若是偶数就 打印偶数
                evenLatch.countDown();
            } else {
                oddLatch.countDown();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        // 打印偶数
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                // 若是偶数则打印
                evenLatch.await();
                printNumber.accept(i);
                evenLatch = new CountDownLatch(1);
                zeroLatch.countDown();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        // 打印奇数
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                // 若是奇数则打印
                oddLatch.await();
                printNumber.accept(i);
                oddLatch = new CountDownLatch(1);
                zeroLatch.countDown();
            }
        }
    }
}
