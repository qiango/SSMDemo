package com.wangq.ssm.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 5:46 PM 11/29/17
 */
public class IoTest2  {//字节流demo

    /**
     *byte b[] = s.getBytes();//String转换为byte[]
     String t = new String(b);//bytep[]转换为String
     *
     *
     */

    @Test
    public void get()throws IOException{
        FileOutputStream fileOutputStream=new FileOutputStream("zifu.txt");//字节流写入不需要flush
        fileOutputStream.write("xixixihahhah".getBytes());
        fileOutputStream.close();
        FileInputStream fileInputStream=new FileInputStream("zifu.txt");
        int l=0;
        byte [] bytes=new byte [1024];
        while ((l=fileInputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,l));
        }
        fileInputStream.close();
        //还有如下这个方法，直接读取文件大小，但是文件过大就不能用
        byte [] bytess=new byte [fileInputStream.available()];
        fileInputStream.read(bytess);
        System.out.println(new String(bytess));
    }


}
