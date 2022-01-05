package leetcode1195;

import java.util.function.IntConsumer;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 四个线程
 * @date 2021/12/24 16:24
 * @see
 */
public class FizzBuzz {

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        // 当n 能被3整除打印 fizz

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        // 当n 能被5整除打印 buzz
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        // 当n 能被15整除打印 fizzbuzz
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        // 当n 不能能被3整除也不能被5整数打印 数字n
    }
}
