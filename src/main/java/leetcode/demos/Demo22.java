package leetcode.demos;

/**
 * @Author: WangTongGang
 * @Create: 2020/6/8 21:49
 * @Description:
 */
public class Demo22 {

        public static void main(String[] args) {
            String[] arrStr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            int[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Thread t1 = null;
            Thread t2 = null;
            final Object lock = new Object();
            t1 = new Thread(() -> {
                synchronized (lock) {
                    for (int i = 0; i < arrStr.length; i++) {
                        System.out.println(arrStr[i]);
                        lock.notify();
                        try {
                            if (i < arrInt.length) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t2 = new Thread(() -> {
                synchronized (lock) {
                    for (int i = 0; i < arrInt.length; i++) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(arrInt[i]);
                        lock.notify();
                    }
                }
            });
            t2.start();
            t1.start();
        }

}
