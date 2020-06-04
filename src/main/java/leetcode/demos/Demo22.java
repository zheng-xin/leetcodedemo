package leetcode.demos;

/**
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
}
