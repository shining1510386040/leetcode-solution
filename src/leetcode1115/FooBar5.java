package leetcode1115;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 解法5: synchronized 同步锁+ volitale实现
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar5 {


    /**
     * 锁住的资源，lock
     */
    private Object lock = new Object();

    /**
     * 线程间可见标识
     */
    private volatile boolean fooExec = true;

    private int n;

    public FooBar5(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                if (fooExec) {
                    printFoo.run();
                    i++;
                    fooExec = false;
                    //
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {

            synchronized (lock) {
                if (!fooExec) {
                    printBar.run();
                    i++;
                    fooExec = true;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }

        }
    }

}
