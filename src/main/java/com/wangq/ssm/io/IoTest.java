package com.wangq.ssm.io;

import org.junit.Test;

import java.io.*;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 4:20 PM 11/28/17
 */
public class IoTest {//字符流demo
    @Test
    public void xiezi()throws Exception{//往文件里写文字，一般使用字符流
        FileWriter fileWriter=new FileWriter("test.txt");
        fileWriter.write("哈哈");
        fileWriter.flush();
        fileWriter.close();
    }

    @Test
    public void read() throws Exception{//读取第一种方式
        FileReader fileReader=new FileReader("test.txt");
        int len=0;
        StringBuilder stringBuilder=new StringBuilder();
        while ((len=fileReader.read())!=-1){
            char len1 = (char) len;//读出来是二进制
            stringBuilder.append(len1);
            System.out.println(len);
        }
        System.out.println(stringBuilder);
    }

    @Test
    public void read2()throws Exception{//读取第二种方式
        FileReader fileReader=new FileReader("test.txt");
        char [] bytes=new char[1024];
        int len=0;
        while ((len=fileReader.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }

    @Test
    public void copy()throws Exception{//复制文件,字符流
        FileReader fileReader=new FileReader("test.txt");
        FileWriter fileWriter=new FileWriter("copy_test.txt");
        int len=0;
        char [] chars=new char[1024];
        while ((len=fileReader.read(chars))!=-1){
            fileWriter.write(chars,0,len);
        }
        fileReader.close();
        fileWriter.close();
    }

    @Test
    public void bufferWriter() throws IOException{//字符流缓冲区的使用，缓冲去中一定要放流对象。
        FileWriter fileWriter=new FileWriter("buffer.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);//使用一个缓冲区将流接住，提高效率，就如同超市里的购物车。
        bufferedWriter.write("hahahah");
        bufferedWriter.newLine();//换行
        bufferedWriter.write("xixixi");
        bufferedWriter.flush();//写入完后一定要刷新
        bufferedWriter.close();//关闭它的同时，流也会被关闭
    }
    /**
     *
     *readLine()原理：使用了读取缓冲区的read方法，将读取到的字符串进行缓冲并判断换行标记，将标记前的缓存数据变成字符串返回。
     *
     */
    @Test
    public void bufferReader()throws IOException{
        FileReader fileReader=new FileReader("buffer.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while ((line=bufferedReader.readLine())!=null){//readLine读一行
            System.out.println(line);
        }
        bufferedReader.close();
        //若要读出行号，则使用以下方法
        String  ll=null;
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        while ((ll=lineNumberReader.readLine())!=null){
            System.out.println(lineNumberReader.getLineNumber()+":"+ll);
        }
        lineNumberReader.close();


    }

}
