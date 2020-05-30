package com.zx.demo.designpatterns.proxy;

import java.util.Random;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/30 - 05 - 30 - 14:20
 * @Description: com.zx.demo.designpatterns.proxy
 * @version: 1.0
 */
public class Tank implements IMoveAble, IFire {
    public void move(){
        System.out.println("move....");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("stop.....");
    }

    @Override
    public void fire() {
        System.out.println("Fire...");
    }
}
