package com.zx.demo.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/30 - 05 - 30 - 14:20
 * @Description: com.zx.demo.designpatterns.proxy
 * @version: 1.0
 */
public class Demo01 implements InvocationHandler {
    private Object obj;
    public Demo01(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before.....");
        method.invoke(obj,args);
        System.out.println("after....");
        return null;
    }

    public static void main(String[] args) {
        Tank t = new Tank();
        InvocationHandler demo01 = new Demo01(t);
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IMoveAble m = (IMoveAble) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{IMoveAble.class,IFire.class}, //tank.class.getInterfaces()
                demo01
        );
        m.move();
        m.stop();
        IFire f = (IFire) m;
        f.fire();

    }
}
