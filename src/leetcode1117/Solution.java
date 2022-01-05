package leetcode1117;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 多线程之H2O的生成
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {

        String input = "OOHHHH";

        H2O h2O = new H2O();

        Thread thread1 = new Thread(() -> {
            try {
                h2O.hydrogen(() -> {
                    System.out.print("H");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                h2O.oxygen(() -> {
                    System.out.print("O");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread2.start();

    }


}
