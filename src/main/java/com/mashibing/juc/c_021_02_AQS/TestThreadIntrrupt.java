package com.mashibing.juc.c_021_02_AQS;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/30 - 05 - 30 - 9:43
 * @Description: 测试线程的中断方法
 * @version: 1.0
 */
public class TestThreadIntrrupt {
    public static void main(String[] args)  {
        Thread t = new Thread(()->{
            while (true) {
                System.out.println("begin");

                LockSupport.park();
                Thread.interrupted();
            }
        });
       t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       t.interrupt();
        System.out.println(Thread.interrupted());
    }

}
