package leetcode1114;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 3个线程按顺序打印
 * @date 2021/12/24 11:00
 * @see
 */
public class Foo {


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
