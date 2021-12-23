package leetcode1115;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 解法6：使用LookSupport 锁实现
 * <p>
 * 类似于信号量：初始时许可数为0 unpark() 会将许可设置为为1
 * <p>
 * 许可为0 时若 park()则会阻塞
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar6 {


    /**
     * 存储打印foo 和bar 的线程
     */
    private Map<String, Thread> map = new ConcurrentHashMap<>(2);

    /**
     * 线程间可见标识
     */
    private volatile boolean fooExec = true;

    private int n;

    public FooBar6(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        map.put("foo", Thread.currentThread());
        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (!fooExec) {
                // foo 不能打印阻塞
                LockSupport.park();
            }
            printFoo.run();
            fooExec = false;
            LockSupport.unpark(map.get("bar"));
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        map.put("bar", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (fooExec) {
                LockSupport.park();
            }
            printBar.run();
            fooExec = true;
            LockSupport.unpark(map.get("foo"));
        }
    }

}
