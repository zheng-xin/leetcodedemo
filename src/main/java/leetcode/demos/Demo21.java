package leetcode.demos;

import java.util.concurrent.locks.LockSupport;

public class Demo21 extends Thread{

     Demo21 next;
     Demo21 head;
     String name;
    public Demo21(Demo21 head,Demo21 next,String name){
        this.head = head;
        this.next = next;
        this.name = name;

    }
    @Override
    public void run() {
        while (true) {
            System.out.println(name);
            if(this.next == null) {
                LockSupport.unpark(head);
            } else {
                LockSupport.unpark(next);
            }
            LockSupport.park();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo21 d1 = new Demo21(null,null,"A");
        Demo21 d2 = new Demo21(d1,null,"B");
        Demo21 d3 = new Demo21(d1,null,"C");
        Demo21 d4 = new Demo21(d1,null,"D");
        d1.next = d2;
        d2.next = d3;
        d3.next = d4;
        d1.start();
        Thread.sleep(100);
        d2.start();
        Thread.sleep(100);
        d3.start();
        Thread.sleep(100);
        d4.start();
    }
}
