package com.mashibing.juc.c_021_02_AQS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAqs {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread[] threads = new Thread[10];
        for (int i = 0;i < threads.length;i++) {
            threads[i] = new Thread(()->{
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(300000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            },"Thread" + i);
        }
        for (int i = 0;i<threads.length;i++) {
            threads[i].start();
        }
    }
}
