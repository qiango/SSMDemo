package com.wangq.ssm.ThreadTest;

/**
 * Created by Administrator on 2017/12/6.
 */
public class Demo01 {

    public static void main(String[] args) {
        final Function f=new Function();
//        new Thread(
//                new Runnable(){
//
//                    @Override
//                    public void run() {
//                        for(int i=0;i<50;i++){
//                            f.sub();
//                        }
//                    }
//
//                }
//        ).start();
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                            f.sub();
                        }
            }
        };
        new Thread(runnable).start();
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                for(int i=0;i<50;i++){
//                    f.sub();
//                }
//            }
//        };
        for(int i=0;i<50;i++){
            f.main();
        }
    }
}