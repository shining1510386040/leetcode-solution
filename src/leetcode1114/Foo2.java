package leetcode1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 3个线程按顺序打印
 * 解法1：使用两个阻塞的集合控制顺序
 * AtomicInteger
 * @date 2021/12/24 11:00
 * @see
 */
public class Foo2 {

    /**
     * 第一个线程是否执行完：确保 1->2
     */
    private AtomicInteger firstDone = new AtomicInteger(0);
    /**
     * 第二个线程是否执行完：确保2->3
     */
    private AtomicInteger secondDone = new AtomicInteger(0);


    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        // 自增1
        firstDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        // 等待线程1执行结束
        while (firstDone.get() != 1) {
            // 空悬
        }
        printSecond.run();
        secondDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (secondDone.get() != 1) {
            // 空悬
        }
        printThird.run();
    }
}
