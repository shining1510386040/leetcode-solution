package leetcode1195;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 交替打印字符串
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {

        int n = 15;
//        FizzBuzz fizzBuzz = new FizzBuzz(n);
        FizzBuzz1 fizzBuzz = new FizzBuzz1(n);
//        FizzBuzz2 fizzBuzz = new FizzBuzz2(n);

        Thread thread1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> {
                    System.out.print(" fizz ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> {
                    System.out.print(" buzz ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> {
                    System.out.print(" fizzbuzz ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();

        Thread thread4 = new Thread(() -> {
            try {
                fizzBuzz.number((e) -> {
                    System.out.print(" " + e + " ");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread4.start();

    }


}
