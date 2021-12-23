package leetcode1115;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 解法3：使用ReetranctLock可重入锁和 volitale实现
 * 实现原理
 * <p>
 * ReentrantLock主要利用CAS+AQS队列来实现。它支持公平锁和非公平锁，两者的实现类似。
 * <p>
 * CAS：Compare and Swap，比较并交换。CAS有3个操作数：内存值V、预期值A、要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。该操作是一个原子操作，被广泛的应用在Java的底层实现中。在Java中，CAS主要是由sun.misc.Unsafe这个类通过JNI调用CPU底层指令实现
 * <p>
 * ReentrantLock主要利用CAS+AQS队列来实现。它支持公平锁和非公平锁，两者的实现类似。
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar3 {


    /**
     * 可重入锁：公平锁
     */
    private ReentrantLock lock = new ReentrantLock(true);

    /**
     * 线程可见标识：是否可以打印foo
     */
    private volatile boolean fooExec = true;

    private int n;

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            try {
                if (fooExec) {
                    printFoo.run();
                    i++;
                    fooExec = false;
                }
            } finally {
                // 对应前面的lock 加锁，一定确保是否锁
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!fooExec) {
                    printBar.run();
                    i++;
                    fooExec = true;
                }
            } finally {
                lock.unlock();
            }

        }
    }

}
