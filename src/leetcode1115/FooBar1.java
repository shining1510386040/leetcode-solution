package leetcode1115;

import java.util.concurrent.Semaphore;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 解法1：使用信号量
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar1 {

    /**
     * 信号量：
     * fooSema.acquire(); 消耗一个许可，当许可数为0时阻塞
     * fooSema.release();释放一个许可
     */
    private Semaphore fooSema = new Semaphore(1);
    // 初始许可数为0
    private Semaphore barSema = new Semaphore(0);

    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            // foo信号量消耗一个许可，许可数变为0再申请许可会被阻塞
            fooSema.acquire();
            printFoo.run();
            // bar信号量释放一个许可，许可数变为1
            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            barSema.acquire();
            printBar.run();
            fooSema.release();
        }
    }

}
