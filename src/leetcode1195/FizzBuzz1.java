package leetcode1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 四个线程
 * 解法1：
 * @date 2021/12/24 16:24
 * @see
 */
public class FizzBuzz1 {


    /**
     * 1个许可的信号量
     */
    private Semaphore semaphore = new Semaphore(1);

    /**
     * 当前打印的位置
     */
    private int cur = 1;

    private int n;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        // 当n 能被3整除打印 fizz
        while (true) {
            semaphore.acquire();
            try {
                if (cur > n) {
                    return;
                }
                if (cur % 3 == 0 && cur % 5 != 0) {
                    cur++;
                    printFizz.run();
                }
            } finally {
                semaphore.release();
            }
        }


    }


    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        // 当n 能被5整除打印 buzz
        while (true) {
            semaphore.acquire();
            try {
                if (cur > n) {
                    return;
                }
                if (cur % 3 != 0 && cur % 5 == 0) {
                    cur++;
                    printBuzz.run();
                }
            } finally {
                semaphore.release();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        // 当n 能被15整除打印 fizzbuzz
        while (true) {
            semaphore.acquire();
            try {
                if (cur > n) {
                    return;
                }
                if (cur % 3 == 0 && cur % 5 == 0) {
                    cur++;
                    printFizzBuzz.run();
                }
            } finally {
                semaphore.release();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        // 当n 不能能被3整除也不能被5整数打印 数字n
        while (true) {
            semaphore.acquire();
            try {
                if (cur > n) {
                    return;
                }
                if (cur % 3 != 0 && cur % 5 != 0) {

                    printNumber.accept(cur);
                    cur++;
                }
            } finally {
                semaphore.release();
            }

        }
    }
}
