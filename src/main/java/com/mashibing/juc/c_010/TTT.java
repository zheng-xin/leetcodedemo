package com.mashibing.juc.c_010;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/19 - 05 - 19 - 22:28
 * @Description: ËÀËøÀı×Ó
 * @version: 1.0
 */
public class TTT {

    public synchronized void m1(TTT t){
        System.out.println("m1 begin......");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.m2(this);
        System.out.println("m1 end.....");


    }
    public synchronized  void m2(TTT t){
        System.out.println("m2 begin......");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.m1(this);
        System.out.println("m2 end........");

    }

    public static void main(String[] args) {
        TTT t1 = new TTT();
        TTT t2 = new TTT();
        new Thread(()->{
            t1.m1(t2);
        }).start();
        t2.m2(t1);

    }
}
