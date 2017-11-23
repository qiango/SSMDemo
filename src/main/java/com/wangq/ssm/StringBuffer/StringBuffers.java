package com.wangq.ssm.StringBuffer;

import org.junit.Test;

public class StringBuffers {

    /*
    1，添加：
        StringBuffer append(data)
        StringBuffer insert(index,data),index为位置
        如：StringBuffer s=new StringBuffer("xixi");
        s.insert(2,qq);
        s="xiqqxi";
    2,删除
        StringBuffer delete(start,end)包含头，不包含尾

     3、修改

     replace(start,end,data)包含头不含尾
     setCharAt(index,data),指定位置换

     StringBuffer 是线程同步，速度慢，每次要判断锁，适用于多线程，反之StringBuilder

     indexOf(int ch)
     */
    StringBuffer b=new StringBuffer();

    @Test
    public void getNum(){//一串字符串，统计字符出现的个数
        String str="sidjgskijdn";
        int count=0;
        String key="j";
        System.out.println(key.length());
        int index=0;
        while ((index=str.indexOf(key,index))!=-1){
            index=index+key.length();
            count++;
        }
        System.out.println("count="+count);

    }


}
