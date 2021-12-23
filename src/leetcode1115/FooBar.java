package leetcode1115;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 共享资源
 * @date 2021/12/23 16:12
 * @see
 */
public class FooBar {


    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.

            printFoo.run();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            printBar.run();
        }
    }

}
