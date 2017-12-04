package com.wangq.ssm.io;

import org.junit.Test;

import java.io.*;

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

    @Test
    public void copy()throws IOException{
        FileInputStream fileInputStream=new FileInputStream("download.jpg");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream=new FileOutputStream("copy_download.png");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        int l=0;
        byte [] bytes=new byte[1024];
        while ((l=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,l);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     *InputStreamReader，属于字符流，能将字节流转换成字符流
     *
     *
     *OutputStreamWriter，属于字符流，能将字符流转换成字节流
     *
     */
    @Test
    public void change()throws IOException{
        BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream("buffer.txt")));
//        BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(System.out));//System.out打印到控制台
        BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("转换流写入.txt")));
        String line=null;
        while ((line=buf.readLine())!=null){
            if("over".equals(line)){
                    break;
            }
            buw.write(line.toUpperCase());
            buw.newLine();
            buw.flush();
        }
    }

    /**
     *
     *将一个中文字符串数据按照指定的编码表写入到一个文本文件中
     *因为fileWriter内部使用的是默认的本地码表，只能使用其父类->OutputStreamWriter
     *OutputStreamWriter接受一个字节流输出对象，既然是操作文件，那个该对象应该是fileOutputStream
     *OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream("test.txt"),"utf-8");
     *什么时候用转换流呢，
     * 1、源或者目的对应的设备是字节流，但是操作的却是文本数据，可以使用转换流作为桥梁，
     *2、一旦操作的文本涉及到具体的指定的编码表时，必须使用转换流
     */

    @Test
    public void getTest()throws IOException{

        InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream("test.txt"),"utf-8");
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("tests.txt"));
        char [] bytes=new char[1024];
        int line=0;
        while ((line=inputStreamReader.read(bytes))!=-1){
            bufferedWriter.write(bytes,0,line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }


}
