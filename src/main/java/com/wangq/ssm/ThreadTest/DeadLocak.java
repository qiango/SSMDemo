package com.wangq.ssm.ThreadTest;

import com.wangq.ssm.util.Lock;

public class DeadLocak implements Runnable{

    private boolean flag;

    DeadLocak(boolean flag){
        this.flag=flag;
    }
    @Override
    public void run() {

        if(flag){
            synchronized (Lock.locka){
                System.out.println(Thread.currentThread().getName()+"......if locka");
                synchronized (Lock.lockb){
                    System.out.println(Thread.currentThread().getName()+"......if lockb");
                }

            }

        }else {
            synchronized (Lock.lockb){

                System.out.println(Thread.currentThread().getName()+"......else lockb");
                synchronized (Lock.locka){
                    System.out.println(Thread.currentThread().getName()+"......else locka");

                }
            }

        }

    }
}
