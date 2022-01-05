package leetcode1114;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 按序打印-3个线程
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    /**
     * 题目要求按顺序依次执行三个方法，且每个方法都在单独的线程中运行。为了保证线程的执行顺序，可以在方法之间创建一些依赖关系，即第二个方法必须在第一个方法之后执行，第三个方法必须在第二个方法之后执行。
     * <p>
     * 方法对之间的依赖关系形成了所有方法的特定的执行顺序。例如 A < B, B < C，则所有方法的执行顺序为 A < B < C。
     */
    public static void main(String[] args) throws InterruptedException {

//        Foo1 foo = new Foo1();
//        Foo2 foo = new Foo2();
        Foo3 foo = new Foo3();

        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.print("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.print("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.print("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }


}
