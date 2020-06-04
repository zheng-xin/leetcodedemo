package leetcode.demos;

/**
 * ���������
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
            Thread.sleep(1000);//����������ߵ�ʱ�߳�1�����ǲ���Ҫ��ֻҪ�߳�1����������������ͺ�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
