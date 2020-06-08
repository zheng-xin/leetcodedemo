package leetcode.demos;

/**
<<<<<<< HEAD
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

=======
 * 二进制求和
 */
public class Demo22 {
    public synchronized void test(){
        System.out.println("father test");
    }
    public synchronized void test2(){
        System.out.println("father test2");
        while(true);
    }
     static class Son extends Demo22{

        public synchronized void test(){
            System.out.println("son test");
        }
        public  void test2(){
            super.test2();
        }
    }
    public static void main(String[] args) {
        Son son = new Son();
        Thread thread1= new Thread(()->{
            son.test2();
        });
        Thread thread2 = new Thread(()->{
            son.test();
        });
        thread1.start();
        try {
            Thread.sleep(1000);//这里可能休眠的时线程1，但是不重要，只要线程1能先启动，获得锁就好
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
>>>>>>> origin/master
}
