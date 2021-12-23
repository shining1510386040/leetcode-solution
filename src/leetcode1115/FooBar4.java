package leetcode1115;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 解法4：使用BlockingQueue的阻塞特性
 * <p>
 * LinkedBlockingQueue：当队列中元素为空时，获取元素会阻塞，当队列中元素满时，添加元素会阻塞
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar4 {


    /**
     * 一个元素容量的阻塞队列,并添加了一个元素
     */
    private BlockingQueue<String> fooQueue = new LinkedBlockingQueue<String>(1) {{
        add("123");
    }};

    private BlockingQueue<String> barQueue = new LinkedBlockingQueue<String>(1);


    private int n;

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            // 当队列中元素为空时，当前线程会阻塞
            fooQueue.take();
            printFoo.run();
            barQueue.add("123");
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.add("123");
        }
    }

}
