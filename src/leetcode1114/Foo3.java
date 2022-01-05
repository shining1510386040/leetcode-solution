package leetcode1114;

import java.util.concurrent.Semaphore;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 3个线程按顺序打印
 * 解法3：使用信号量控制
 * @date 2021/12/24 11:00
 * @see
 */
public class Foo3 {

    /**
     * 3个许可的信号量
     */
    private Semaphore semaphore = new Semaphore(3);

    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        // 3-> 2
        semaphore.acquire();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (semaphore.availablePermits() != 2){
            // 阻塞，空悬
        }
        printSecond.run();
        semaphore.acquire();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (semaphore.availablePermits() !=1){
            // 空悬
        }
        printThird.run();
        semaphore.acquire();
    }
}
