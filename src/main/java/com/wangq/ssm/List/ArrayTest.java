package com.wangq.ssm.List;

import org.junit.Test;

/**
 * @Author:qianwang
 * @Description:
 * @Date:Create in 11:13 AM 11/28/17
 */
public class ArrayTest {


    @Test
    public void get(){
        int s=newAdd(1,2,5,6);//调用不需要再new一个数组，直接传参就好.
        System.out.println(s);
    }


    public static int newAdd(int ... arr){//数组新写法，随意个参数，简化了调用者的书写
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    public void  gett(int arr[]){

    }



}
