package leetcode1115;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 多线程-循环打印foobar
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {

        int n = 3;
//        FooBar fooBar = new FooBar(n);
//        FooBar1 fooBar = new FooBar1(n);
//        FooBar2 fooBar = new FooBar2(n);
//        FooBar3 fooBar = new FooBar3(n);
//        FooBar4 fooBar = new FooBar4(n);
//        FooBar5 fooBar = new FooBar5(n);
        FooBar6 fooBar = new FooBar6(n);

        Thread thread1 = new Thread(() -> {
            System.out.print("foo");
        });

        Thread thread2 = new Thread(() -> {
            System.out.print("bar");
        });

        Thread fooThread = new Thread(() -> {

            try {
                fooBar.foo(thread1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread barThread = new Thread(() -> {

            try {
                fooBar.bar(thread2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fooThread.start();
        barThread.start();

    }
}
