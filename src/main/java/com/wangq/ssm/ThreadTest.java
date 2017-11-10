package com.wangq.ssm;

import org.junit.Test;
/*
    创建线程的第一种方法：集成thread类
    第二种方法：实现接口Runable接口
    通过Thread类创建线程对象，并将Runnable接口子类对象作为Thread类构造函数的参数进行传递，为什么？因为线程的任务都封装在Runable接口子类对象的run方法中。
    所以要在线程创建对象时就必须明确要运行的任务。
 */
public class ThreadTest {

    @Test
    public void test(){

    Threadss threadss=new Threadss("wangqian");
    Thread thread=new Thread(threadss);
        threadss.start();
// thread.start();
    }


}
