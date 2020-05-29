https://blog.csdn.net/qq_30572275/article/details/80297047
reetrantLock详细说明 zhengxin
1.构造方法 可以传递Boolean 类型变量 实现公平和非公平  默认不传递 是非公平锁
2.lock() 没有返回值 加锁失败会阻塞 首先调用cas操作  尝试将父类（aqs）中的state设置成1，如果成功那么加锁成功，失败了会调用父类的acquire方法
这个方法首先会调用需要子类实现的tryAcquire() 获取当前的state 如果是0那么再次枪锁 如果不是0 并且线程是当前获得锁的线程 那么记录冲入次数 state + 1
如果再次枷锁失败将当前线程封装成Node 放入到队列中 添加Node的过程是个循环的过程 采用cas操作 想链表尾部添加节点  知道添加成功为止
节点成功添加到队列之后