package leetcode1195;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 四个线程
 * 解法2；使用回环
 * @date 2021/12/24 16:24
 * @see
 */
public class FizzBuzz2 {


    /**
     * 4 个线程参与的回环：
     */
    private CyclicBarrier cb = new CyclicBarrier(4);

    private int n;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        // 当n 能被3整除打印 fizz
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                // 打印fizz
                printFizz.run();
            }
            try {
                // 则塞 当前线程
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        // 当n 能被5整除打印 buzz
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                // 打印fizz
                printBuzz.run();
            }
            try {
                // 则塞 当前线程
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        // 当n 能被15整除打印 fizzbuzz
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // 打印fizz
                printFizzBuzz.run();
            }
            try {
                // 则塞 当前线程
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        // 当n 不能能被3整除也不能被5整数打印 数字n
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                // 打印fizz
                printNumber.accept(i);
            }
            try {
                // 则塞 当前线程
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
