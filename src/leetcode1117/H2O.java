package leetcode1117;

import java.util.concurrent.Semaphore;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 共享资源
 * @date 2022/1/5 16:37
 * @see
 */
public class H2O {

    /**
     * h信号量，两个许可
     */
    private Semaphore hSem = new Semaphore(2);

    /**
     * o信号量，
     */
    private Semaphore oSem = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hSem.acquire();
        releaseHydrogen.run();
        oSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        // 一次获取两个许可
        oSem.acquire(2);
        releaseOxygen.run();
        hSem.release(2);
    }
}
