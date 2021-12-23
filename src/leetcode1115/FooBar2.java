package leetcode1115;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 解法2：使用yield()
 * Thread.yield():使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。cpu会从众多的可执行态里选择，也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，并不是说一定会执行其他线程而该线程在下一次中不会执行到了。
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar2 {


    private int n;

    /**
     * 线程可见的变量：foo是否可打印
     */
    private volatile boolean fooExec = true;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            if (fooExec) {
                printFoo.run();
                fooExec = false;
                i++;
            } else {
                // 当前线程变为就绪转态，争抢cpu资源
                Thread.yield();
            }


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {

            if (!fooExec) {
                printBar.run();
                // 改变状态为true
                fooExec = true;
                // 只有在打印了bar后才i++
                i++;
            } else {
                Thread.yield();
            }
        }
    }

}
