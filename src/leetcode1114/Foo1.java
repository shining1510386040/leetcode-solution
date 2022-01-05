package leetcode1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 3个线程按顺序打印
 * 解法1：使用两个CountDownLatch 控制三个线程的执行顺序
 * @date 2021/12/24 11:00
 * @see
 */
public class Foo1 {

    /**
     * 第一个线程是否执行完：确保 1->2
     */
    private CountDownLatch firstDone = new CountDownLatch(1);
    /**
     * 第二个线程是否执行完：确保2->3
     */
    private CountDownLatch secondDone = new CountDownLatch(1);


    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        // 等待线程1执行结束
        firstDone.await();
        printSecond.run();
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        secondDone.await();
        printThird.run();
    }
}
