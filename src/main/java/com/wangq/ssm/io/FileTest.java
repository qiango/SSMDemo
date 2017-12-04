package com.wangq.ssm.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 3:05 PM 12/1/17
 */
public class FileTest {

    @Test
    public void file(){
        //File.separator是系统的分隔符，在linux上是/,而在window上是\\
        File file=new File(File.separator+"home/hz/apps"+File.separator+"bbb.txt");
        System.out.println(file);
    }

    @Test
    public void getDemo() throws IOException {
        File file=new File("demo.txt");
        String name=file.getName();//名称
        String path=file.getPath();//相对路径
        String absPath=file.getAbsolutePath();//
        long len=file.length();//大小
        long time=file.lastModified();//时间
        System.out.println(name);
        System.out.println(path);
        System.out.println(absPath);
        System.out.println(len);
        System.out.println(time);
        boolean b=file.createNewFile();//创建文件
        boolean b1=file.delete();//删除
    }
    /**
     *
     *
     *截取字符串
     *中文占两个字节，并且是负数的，如果长度包括了中文的一个字节，则舍弃，两个就获取。
     *
     */
    @Test
    public void getGbk() throws IOException {
        int len=7;
        String str="abcdef你好呀";
        int count =0;
        byte [] bytes=str.getBytes("GBK");
        for (int i=len;i>=0;i--){
            if(bytes[i]<0){
                count++;
            }else
                break;
        }
        if(count%2==0){
            System.out.println(new String(bytes,0,len,"GBK"));
        }else
            System.out.println(new String(bytes,0,len-1,"GBK"));
    }

}
