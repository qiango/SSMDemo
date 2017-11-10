package com.wangq.ssm;

/**
 *线程被创建--》start()-->运行（具备执行资格，执行权）-->sleep(time)冻结（释放执行权，执行资格）
 *                   |                          <--sleep(time)时间到
 *                   |                          -->wait()等待
 *                   |                         <--notify()唤醒
 *临时阻塞状态，具备执行权，等待执行资格(cpu一个个处理)
 *
 *
 */
public class Threadss extends Thread {

    private String name;

    public Threadss(String name) {
        this.name = name;
        System.out.println("构造函数");
    }

    public void run() {
        System.out.println("run方法"+getName());//getName()获取线程名称
        System.out.println(Thread.currentThread().getName());//获取当前线程名称
    }

//    public void start() {
//        System.out.println("start方法");
//    }

}
