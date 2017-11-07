package com.wangq.ssm.util;

public class ThreadTest {
//    现在有T1、T2、T3三个线程，怎样保证T2在T1执行完后执行，T3在T2执行完后执行？使用Join
//        public static void main(String[] args)
//        {
//            Thread t1 = new Thread(new T1(), "线程1");
//            Thread t2 = new Thread(new T2(), "线程2");
//            Thread t3 = new Thread(new T3(), "线程3");
//
//            try
//            {
//                //t1先启动
//                t1.start();
//                t1.join();
//                //t2
//                t2.start();
//                t2.join();
//                //t3
//                t3.start();
//                t3.join();
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }

