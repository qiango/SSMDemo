package com.wangq.ssm.ThreadTest;

/**
 * Created by Administrator on 2017/12/6.
 */
class Demo02 {

    private int  i=0;
    public static void main(String[] args) {
        Demo02 demo=new Demo02();
        Add add = demo.new Add();
        Sub sub = demo.new Sub();
        for(int i=1;i<=2;i++){
            new Thread(add,"线程"+i).start();
            new Thread(sub,"线程"+i).start();
        }
    }


    //定义一个内部类Add,实现功能每次对i加一
    class Add implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                addOne();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //定义一个内部类Sub,实现功能每次对i减1
    class Sub implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                subOne();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public synchronized void addOne() {
        i++;
        System.out.println(Thread.currentThread().getName()+"加一的值为:"+i);
    }
    public synchronized void subOne(){
        i--;
        System.out.println(Thread.currentThread().getName()+"减一的值为:"+i);
    }
}
