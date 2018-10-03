package com.wangq.ssm.ThreadTest;

import org.junit.Test;
/*
    创建线程的第一种方法：集成thread类
    第二种方法：实现接口Runable接口
    通过Thread类创建线程对象，并将Runnable接口子类对象作为Thread类构造函数的参数进行传递，为什么？因为线程的任务都封装在Runable接口子类对象的run方法中。
    所以要在线程创建对象时就必须明确要运行的任务。
    好处：1、将线程的任务从线程的子类中单独分离出来，单独进行了封装，按照面向对象的思想将任务的封装成对象
    2、避免了java单继承的局限

    线程问题：当一个线程在执行操作共享数据的多条代码过程中，其他线程参与了计算，就会导致线程安全的问题的产生。
    解决：加个同步（synchronized(对象))解决了线程的安全问题，同时相对降低了效率，因为同步外的线程都会判断同步锁
    前提：必须有多个线程使用同一个锁。

    同步函数的所使用的this

    同步函数和同步代码块的区别：
    建议使用同步代码块

    单力设计模式中饿汉式多线程去访问，在锁外多加一层判断，判断对象是否为空，这样后面进来的线程就不用判断锁了。


   wait()等待，notify()唤醒一个线程，notifyAll(),唤醒线程池中所有的线程
   以上三个方法都归为object类下，因为这些方法是监视器的方法，监视器其实就是锁，所可以是任意的对象，任意的对象调用的方一定定义在object类中

   if()判断标记，只有一次，会导致不改运行的线程运行了，出现了数据错误的情况。while判断标记，解决了线程获取执行权后，是否要运行。

   wait可以指定时间，也可以不指定，sleep（）必须有时间

   线程可以使用interrupt（）方法将线程从冻结状态强制恢复到运行状态中来，让线程具备cpu的执行资格

   t.setDaemon(true)，此方法在线程执行前调用，调用后，当所有线程都处于冻结状态后，此线程也变成冻结状态

 */
public class ThreadTestsss {

    @Test
    public void test(){
<<<<<<< HEAD

    Threadss threadss=new Threadss("wangqian");
    Thread thread=new Thread(threadss);
        thread.start();
// thread.start();
=======
        Threadss threadss=new Threadss("wangqian");
        Thread thread=new Thread(threadss);
//        threadss.start();
            thread.start();
>>>>>>> 3d37b041edd512fc5a34436de43efe0fe121db7a
    }


    //死锁示例，原理为同步嵌套，各自拿各自的锁，互相不放，等待对方的锁释放，从而进入无限循环的等待
    @Test
    public void deadLockTest(){
        DeadLocak a=new DeadLocak(true);
        DeadLocak b=new DeadLocak(false);
        Thread t1=new Thread(a);
        Thread t2=new Thread(b);
        t1.start();
        t2.start();
    }

}

//class Test implements Runnable{
//
//public void run(Thread t){
//
//}
//}
//以上代码第一行错误，该类应该被abstract修饰
//new Thread(
// public void run(){
// syn("222")
// }
// ){
// public void run(){
// syn("111")
// }
//
// }.start
//会先输出111，输出其子类方法，子类覆盖了