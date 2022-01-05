package leetcode1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 打印0、奇数、偶数；三个线程
 * 有问题： todo...
 * @date 2021/12/24 14:48
 * @see
 */
public class ZeroEvenOdd2 {

    /**
     * 打印的状态：0 打印0；1打印奇数，2打印偶数
     */
    private volatile int state = 0;

    private Lock lock = new ReentrantLock();

    private Condition zeroCondition = lock.newCondition();

    private Condition evenCondition = lock.newCondition();

    private Condition oddCondition = lock.newCondition();

    private int n;

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        // 打印0
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {

                if (state != 0) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                if (i % 2 == 0) {
                    state = 2;
                    evenCondition.signal();
                } else {
                    state = 1;
                    oddCondition.signal();
                }
                zeroCondition.await();
            }
            oddCondition.signal();
            evenCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        // 打印偶数
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                if (state != 2) {
                    // 阻塞等待
                    evenCondition.await();
                }
                printNumber.accept(i);
                state = 0;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        // 打印奇数
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                if (state != 1) {
                    // 阻塞等待
                    oddCondition.await();
                }
                printNumber.accept(i);
                state = 0;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
